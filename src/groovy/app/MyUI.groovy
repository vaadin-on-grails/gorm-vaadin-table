package app

import com.vaadin.data.util.BeanItemContainer
import com.vaadin.grails.ui.VaadinUI
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Grid
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadinongrails.Item

@VaadinUI(path = '/')
class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout()
        layout.setMargin(true)

        Grid grid = new Grid()
        grid.setSelectionMode(Grid.SelectionMode.SINGLE)

        BeanItemContainer<Item> container = new BeanItemContainer<>(Item.class)
        List<Item> all = Item.findAll()
        container.addAll(all)
        grid.setContainerDataSource(container)

        grid.setColumnOrder("id", "name", "other")
        grid.removeColumn("attached")
        grid.removeColumn("metaClass")
        grid.removeColumn("properties")
        grid.removeColumn("version")
        grid.removeColumn("dirty")
        grid.removeColumn("dirtyPropertyNames")
        grid.removeColumn("errors")

        layout.addComponent(grid)

        // example of how to get Grails service and call a method
        // List<User> users = Grails.get(UserService).getListOfUsers()
        //    for (User user : users) {
        //    	layout.addComponent(new Label(user.name))
        // }

        setContent(layout)
    }
}
