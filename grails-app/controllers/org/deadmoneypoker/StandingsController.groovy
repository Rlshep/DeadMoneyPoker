package org.deadmoneypoker

import grails.converters.JSON
import org.deadmoneypoker.constants.DeadMoneyPokerConstants
import org.deadmoneypoker.domain.Result
import org.deadmoneypoker.domain.Season

class StandingsController {
    private static final TOTAL = 'Total'
    private static final NAME = 'Name'
    private static final NULL = 'null'

    def index() { }

    def load() {
        render getStandingsJson(getParamSeasonName())
    }

    def loadHeaders() {
        def season = Season.getSeason(getParamSeasonName())
        render getHeadersJson(Result.getDatesPlayedBySeason(season)) as JSON
    }

    def getSeasonNames() {
        render Season.list(sort: 'startYear', order: 'desc') as JSON
    }

    def getChampionshipResult() {
        render getChampionshipResultJson() as JSON
    }

    private getChampionshipResultJson() {
        def season = Season.getSeason(getParamSeasonName())
        ["data": Result.getSeasonChampionshipResult(season)]
    }

    private getParamSeasonName() {
        def seasonName = null

        if (NULL != params.seasonName && params.seasonName) {
            seasonName = params.seasonName
        }

        seasonName
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

    private getStandingsJson(seasonName) {
        def json = '{"data": ['
        def name
        def points
        def totalPoints
        def season = Season.getSeason(seasonName)

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
