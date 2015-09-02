package org.deadmoneypoker.domain

class Season {
    static hasMany = [result: Result]

    String name
    int startYear

    static constraints = {
        name(blank: false, unique: true)
        startYear(nullable: true, required: false)
    }

//    public static def getLatestSeason() {
//        // TODO: Find out why this doesn't work.
////        final def query = Season.where { startYear == max(startYear) }
////        query.find()
//
//        final def query = Season.where { startYear == Season.executeQuery('SELECT MAX(startYear) FROM Season') }
//        query.find()
//    }
//
//    public static def getFirstSeason() {
//        final def query = Season.where { startYear == Season.executeQuery('SELECT MIN(startYear) FROM Season') }
//        query.find()
//    }

}
