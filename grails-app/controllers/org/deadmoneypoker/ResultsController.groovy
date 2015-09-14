package org.deadmoneypoker
import grails.converters.JSON
import org.deadmoneypoker.constants.DeadMoneyPokerConstants
import org.deadmoneypoker.domain.Result

class ResultsController {
    def index() {
    }

    def load() {
        render getResultsJson(getDateFromParam())
    }

    def loadDateRange() {
        def dateRange = ["lowDate": Result.getFirstResult().datePlayed, "highDate": Result.getLatestResult().datePlayed]
        render dateRange as JSON
    }

    private getResultsJson(date) {
        ["data": Result.getResultsByMonthYear(date)] as JSON
    }

    private Date getDateFromParam() {
        def date;

        if (params.selectedDate) {
            if (params.selectedDate.length() == 7) {
                date = new Date().parse(DeadMoneyPokerConstants.MONTH_FORMAT, params.selectedDate)
            }
        }
        date
    }
}
