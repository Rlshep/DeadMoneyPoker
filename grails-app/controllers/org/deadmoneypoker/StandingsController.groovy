package org.deadmoneypoker

import grails.converters.JSON
import org.deadmoneypoker.constants.DeadMoneyPokerConstants
import org.deadmoneypoker.domain.Result
import org.deadmoneypoker.domain.Season

class StandingsController {
    private static final TOTAL = 'Total'
    private static final NAME = 'Name'

    def index() { }

    def load() {
        render getStandingsJson(getDateFromParam())
    }

    def loadDateRange() {
        def dateRange = ["lowDate": Season.getFirstSeason().startYear, "highDate": Season.getLatestSeason().startYear]
        render dateRange as JSON
    }

    def loadHeaders() {
        def season = Season.getSeason(getDateFromParam())
        render getHeadersJson(Result.getDatesPlayedBySeason(season)) as JSON
    }

    private getHeadersJson(results) {
        def headers = []

        headers.add(NAME)

        results.each {
            headers.add(it)
        }

        headers.add(TOTAL)

        ["data": headers]
    }

    private Date getDateFromParam() {
        def date;

        if (params.seasonDate) {
            if (params.seasonDate.length() == 7) {
                date = new Date().parse(DeadMoneyPokerConstants.MONTH_FORMAT, params.seasonDate)
            }
        }
        date
    }

    private getStandingsJson(date) {
        def json = '{"data": ['
        def name
        def points
        def totalPoints
        def season = Season.getSeason(date)

        def allPlayerNames = Result.getPlayerNamesBySeason(season)
        def datesPlayed = Result.getDatesPlayedBySeason(season)

        def i = 0
        while (i < allPlayerNames.size()) {
            name = allPlayerNames[i]
            totalPoints = 0
            json += '{"'
            json += NAME + '": "' + name + '"'

            datesPlayed.each { playDate ->
                points = getPoints(name, playDate, season.result)
                totalPoints += points
                json += ', "' + playDate.format(DeadMoneyPokerConstants.MONTH_FORMAT) + '": "' + points + '"'
            }

            json += ', "' + TOTAL + '": "' + totalPoints + '"'
            json += '}'

            if (i+1 != allPlayerNames.size()) {
                json += ','
            }

            i++
        }
        json += ']}'

        json
    }

    private getPoints(name, playDate, results) {
        def points = 0

        results.each {
            if (it.playerName == name && it.datePlayed == playDate) {
                points = it.points
            }
        }

        points
    }
}
