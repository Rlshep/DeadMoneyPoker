package org.deadmoneypoker
import grails.converters.JSON
import org.deadmoneypoker.constants.DeadMoneyPokerConstants
import org.deadmoneypoker.domain.Result

class ResultsController {
    def index() {
    }

    def load() {
        def date;

        if (params.resultDate) {
            if (params.resultDate.length() == 7) {
                date = new Date().parse(DeadMoneyPokerConstants.MONTH_FORMAT, params.resultDate)
            }
        }

        render getResultsJson(date)
    }

    def loadDateRange() {
        def dateRange = ["lowDate": Result.getFirstResult().datePlayed, "highDate": Result.getLatestResult().datePlayed]
        render dateRange as JSON
    }

    private getResultsJson(date) {
        ["data": Result.getResultsByMonthYear(date)] as JSON
    }
}
