package org.deadmoneypoker.domain

class Result {
    static belongsTo = [season:Season]

    long id
    Date datePlayed
    String playerName
    int rank
    int points
    BigDecimal winnings
    String timeOut
    String roundOut
    int hits
    String hitmanName
    boolean championshipInd

    static constraints = {
        playerName(blank: false)
        datePlayed(blank: false)
        timeOut(nullable: true)
        roundOut(nullable: true)
        hitmanName(nullable: true)
        championshipInd(defaultValue: false)
    }

    static def getResultsByMonthYear(Date date) {
        if (!date) {
            date = Result.getLatestResult().datePlayed
        }

        final def query = Result.where {
            year(datePlayed) == date[Calendar.YEAR]
            month(datePlayed) == (date[Calendar.MONTH] + 1)
        }

        query.list()
    }

    static def getSeasonChampionshipResult(mySeason) {
        def query = Result.where {
            championshipInd == true
            season.name == mySeason.name
        }

        query.find()
    }

    static def getDatesPlayedBySeason(season) {
        Result.executeQuery("select distinct r.datePlayed from Result r join r.season s where s.name = '" + season.name + "' order by r.datePlayed")
    }

    static def getPlayerNamesBySeason(season) {
        Result.executeQuery("select distinct r.playerName from Result r join r.season s where s.name = '" + season.name + "'")
    }

    static def getLatestResult() {
        final def query = Result.where { datePlayed == Result.executeQuery('SELECT MAX(datePlayed) FROM Result') }
        query.find()
    }

    static def getFirstResult() {
        final def query = Result.where { datePlayed == Result.executeQuery('SELECT MIN(datePlayed) FROM Result') }
        query.find()
    }
}
