package javateam.Models.home_model;

import java.util.Vector;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javateam.Data.db_strategy.Operation;
import javateam.Data.db_strategy.AddBook;
import javateam.Data.db_strategy.DelBook;
import javateam.Data.db_strategy.AddBookstand;

public class HomeAdmin extends Home
{
    @Override
    public void addBook(String title, String author, String type,
                        String description, String bookstandId)
    {
        Operation operation = new AddBook();
        var result = operation.doOperation(bookstandId, title, author, type, description);
        boolean success = (boolean)(result.get(0));

        if (!success)
        {
            String msg = "There's a problem with adding that book to list.\n" +
                    "Check if the bookstand with given id exist.\n" +
                    "Try again.";
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText(msg);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    @Override
    public void addToMyList(String userId, String bookId)
    {
        String msg = "Admin cannot execute that operation.\n" +
                "Log in to your account, or create a new one.";
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @Override
    public void removeBook(String bookId)
    {
        Operation operation = new DelBook();
        operation.doOperation(bookId);
    }
}