package Utils;

import java.io.*;

import ADT.Show;
import Utils.LinkedList.LinkedList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class IO {

    LinkedList<Show> showList;

    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Database.xml"));
        showList = (LinkedList<Show>) is.readObject();
        Main.showList = showList;
        is.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Database.xml"));
        out.writeObject(Main.showList);
        out.close();
    }
}
