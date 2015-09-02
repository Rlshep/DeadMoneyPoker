import grails.converters.JSON
import org.deadmoneypoker.constants.DeadMoneyPokerConstants

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Date) {
            return it?.format(DeadMoneyPokerConstants.MONTH_FORMAT)
        }
    }
    def destroy = {
    }
}
