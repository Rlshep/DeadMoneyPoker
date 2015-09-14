package org.deadmoneypoker.domain

class Season {
    static hasMany = [result: Result]

    String name
    int startYear

    static constraints = {
        name(blank: false, unique: true)
        startYear(blank: false, unique: true)
    }

    public static def getSeason(seasonName) {
        def season

        if (seasonName) {
            season = Season.findByName(seasonName)
        } else {
            season = Season.getLatestSeason()
        }

        season
    }

    public static def getLatestSeason() {
        final def query = Season.where { startYear == Season.executeQuery('SELECT MAX(startYear) FROM Season') }
        query.find()
    }

    public static def getFirstSeason() {
        final def query = Season.where { startYear == Season.executeQuery('SELECT MIN(startYear) FROM Season') }
        query.find()
    }

}
