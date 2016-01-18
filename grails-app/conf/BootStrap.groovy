import com.vaadinongrails.Item

class BootStrap {

    def init = { servletContext ->
        new Item(name: "Hi 1", other: "There").save(failOnError: true)
        new Item(name: "Hi 2", other: "There").save(failOnError: true)
        new Item(name: "Hi 3", other: "There").save(failOnError: true)
        new Item(name: "Hi 4", other: "There").save(failOnError: true)
    }
    def destroy = {
    }
}
