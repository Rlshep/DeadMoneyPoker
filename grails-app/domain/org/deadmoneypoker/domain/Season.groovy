package org.deadmoneypoker.domain

class Season {
    static hasMany = [result: Result]

    String name
    int startYear

    static constraints = {
        name(blank: false, unique: true)
        startYear(blank: false, unique: true)
    }

    public static def getSeason(date) {
        def year

        if (!date) {
            year = Season.getLatestSeason().startYear
        } else {
            year = date[Calendar.YEAR]
        }

        final def query = Season.where {
            startYear == year
        }

        query.find()
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
