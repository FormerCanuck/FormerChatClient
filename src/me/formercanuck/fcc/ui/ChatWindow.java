package me.formercanuck.fcc.ui;

import me.formercanuck.fcc.util.FontAttributeHelper;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;

public class ChatWindow extends JFrame {

    private static ChatWindow chatWindow;                               // Creating singleton of chat window class.

    private BorderLayout layout;                                        // Used as the layout for all components in this window.

    private JScrollPane chatScrollPane;                                 // Scroll pane for the chat history.
    private JTextPane chatTextArea;                                     // Text pane used for chat history.
    private JTextField chatInputField;                                  // Text field used for sending messages to chat.

    private ChatWindow() {
        this.setup();
    }

    private void setup() {
        this.setLayout(layout = new BorderLayout());                    // Setting our local variable of layout and setting the window's layout to that same instance.

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);                   // Setting the default close operation so the program closes when exit button is pressed.
        this.setPreferredSize(new Dimension(700, 394));   // Setting the preferred size of application.
        this.setMinimumSize(new Dimension(700, 394));       // Setting the smallest the application will go.

        this.chatScrollPane = new JScrollPane();                        // Creating and adding the scroll pane to the window.
        this.add(this.chatScrollPane, BorderLayout.CENTER);

        this.chatTextArea = new JTextPane();
        this.chatTextArea.setBackground(Color.DARK_GRAY);
        this.chatTextArea.setEditable(false);
        this.chatScrollPane.add(this.chatTextArea);
        this.chatScrollPane.setViewportView(this.chatTextArea);

        Font font = new Font("Courier", Font.PLAIN, 15);
        this.chatTextArea.setFont(font);

        this.chatInputField = new JTextField();
        this.chatInputField.addActionListener(e -> {
            appendTextToChat(this.chatInputField.getText());
            clearChatInput();
        });
        this.chatInputField.setBackground(Color.DARK_GRAY);
        this.chatInputField.setForeground(Color.PINK);
        this.chatInputField.requestFocus();
        this.add(this.chatInputField, BorderLayout.PAGE_END);

        this.pack();                                                    // Packing the frame size to fit to its components.
        this.setLocationRelativeTo(null);                               // Setting programs location to the center of the screen.
        this.setVisible(true);                                          // Making the program appear on screen.
    }

    public void appendTextToChat(String text) {
        Document document = this.chatTextArea.getStyledDocument();
        try {
            document.insertString(document.getLength(), text + "\n", FontAttributeHelper.get().pink());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void clearChatInput() {
        this.chatInputField.setText("");
    }

    public static ChatWindow get() {
        if (chatWindow == null) chatWindow = new ChatWindow();
        return chatWindow;
    }
}
