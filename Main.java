package finalProj1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Main {
    private static double accountBalance = 0;
    private static final double serviceFee = 5;
    private static final String PASSWORD = "123456";
    
    public static void main(String[] args) {
        Main.LoginFrame loginFrame = new Main.LoginFrame();
        loginFrame.setVisible(true);
    }
    
    private static class LoginFrame extends JFrame {
        private JTextField passwordField;
        
        LoginFrame() {
            setTitle("7-11 Loading Station");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
            
            JLabel passwordLabel = new JLabel("Enter password:");
            passwordField = new JPasswordField(15);
            JButton loginButton = new JButton("Login");
            JButton exitBtn = new JButton("Exit");
            
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(loginButton);
            panel.add(exitBtn);
            
            add(panel);
            
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String enteredPassword = passwordField.getText();
                    if (enteredPassword.equals(PASSWORD)) {
                        dispose();
                        mainMenu();
                    } else {
                        showMessage("Incorrect password. Please try again.");
                    }
                }
            });
            
            AbstractAction enterAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {loginButton.doClick();
                }
            };
            panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "doEnterAction");
            panel.getActionMap().put("doEnterAction", enterAction);
            
            exitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(null,
                            "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                    
                    if (result == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    } else {
                        dispose();
                        setVisible(true);
                    }
                }
            });
            setSize(300, 200);
            setLocationRelativeTo(null);
        }
    }
    
    private static void mainMenu(){
        JFrame menuFrame = new JFrame("7-11 Loading Station");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new BoxLayout(menuFrame.getContentPane(), BoxLayout.Y_AXIS));
        menuFrame.setSize(300, 300);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        JLabel selectTransactionLabel = new JLabel("Select Transaction", SwingConstants.CENTER);
        selectTransactionLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        mainPanel.add(selectTransactionLabel, BorderLayout.NORTH);
        JButton buyGameLoadBtn = new JButton("Buy Game Load");
        JButton buyPhoneLoadBtn = new JButton("Buy Phone Load");
        
        buyGameLoadBtn.setAlignmentX(0.5f);
        buyPhoneLoadBtn.setAlignmentX(0.5f);
        
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPanel.add(Box.createRigidArea(new Dimension(0,15)));
        btnPanel.add(buyGameLoadBtn);
        btnPanel.add(Box.createRigidArea(new Dimension(0,15)));
        btnPanel.add(buyPhoneLoadBtn);
        
        mainPanel.add(btnPanel, BorderLayout.CENTER);
        
        menuFrame.add(mainPanel);
        menuFrame.setVisible(true);
        menuFrame.setLocationRelativeTo(null);
        
        buyGameLoadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
                showGameMenu();
            }
        });
        
        buyPhoneLoadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
                showPhoneMenu();
            }
        });
    }
    
    private static void showGameMenu(){
        JFrame menuFrame = new JFrame("7-11 Loading Station");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new BoxLayout(menuFrame.getContentPane(), BoxLayout.Y_AXIS));
        menuFrame.setSize(400, 400);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        JLabel buyGameLoadLabel = new JLabel("Buy Game Load", SwingConstants.CENTER);
        buyGameLoadLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        mainPanel.add(buyGameLoadLabel, BorderLayout.NORTH);
        JLabel selectProductLabel = new JLabel("Select product", SwingConstants.CENTER);
        JLabel enterQuantityLabel = new JLabel("Enter Quantity", SwingConstants.CENTER);
        JComboBox<String> productComboBox = new JComboBox<>(new String[]{"Garena Shells", "Riot Points", "Genesis Crystals", "Razer Pins"});
        JTextField quantityField = new JTextField(10);
        JButton purchaseBtn = new JButton("Purchase");
        JButton addBalanceBtn = new JButton("Add Balance");
        JButton checkBalanceBtn = new JButton("Check Balance");
        JButton priceListBtn = new JButton("Price List");
        JButton backBtn = new JButton("Go Back");
        JButton exitBtn = new JButton("Exit");
        
        //edit ng button
        selectProductLabel.setAlignmentX(0.5f);
        productComboBox.setMinimumSize(new Dimension(130, 20));
        productComboBox.setMaximumSize(new Dimension(130, 20));
        enterQuantityLabel.setAlignmentX(0.5f);
        quantityField.setMinimumSize(new Dimension(140, 20));
        quantityField.setMaximumSize(new Dimension(140, 20));
        purchaseBtn.setMaximumSize(new Dimension(150, 50));
        purchaseBtn.setMinimumSize(new Dimension(150, 50));
        purchaseBtn.setAlignmentX(0.5f);
        addBalanceBtn.setMaximumSize(new Dimension(150, 50));
        addBalanceBtn.setMinimumSize(new Dimension(150, 50));
        addBalanceBtn.setAlignmentX(0.5f);
        checkBalanceBtn.setMaximumSize(new Dimension(150, 50));
        checkBalanceBtn.setMinimumSize(new Dimension(150, 50));
        checkBalanceBtn.setAlignmentX(0.5f);
        priceListBtn.setMaximumSize(new Dimension(150, 50));
        priceListBtn.setMinimumSize(new Dimension(150, 50));
        priceListBtn.setAlignmentX(0.5f);
        backBtn.setMinimumSize(new Dimension(150, 50));
        backBtn.setMaximumSize(new Dimension(150, 50));
        backBtn.setAlignmentX(0.5f);
        exitBtn.setMaximumSize(new Dimension(150, 50));
        exitBtn.setMinimumSize(new Dimension(150, 50));
        exitBtn.setAlignmentX(0.5f);
        
        //add na yung mga dineclare sa panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(selectProductLabel);
        buttonPanel.add(productComboBox);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(enterQuantityLabel);
        buttonPanel.add(quantityField);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(purchaseBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        buttonPanel.add(addBalanceBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(checkBalanceBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(priceListBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(backBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(exitBtn);
        
        //iadd yung panel sa mainPanel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setContentPane(mainPanel);
        menuFrame.setVisible(true);
        
        purchaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String selectedProduct = (String) productComboBox.getSelectedItem();
                int quantity;
                try{
                    quantity = Integer.parseInt(quantityField.getText());
                    double totalPrice = calculateTotalPriceGame(selectedProduct, quantity);
                    if(totalPrice <= accountBalance) {
                        accountBalance -= totalPrice;
                        showMessage("Successfully purchased " + selectedProduct + "!\nTotal cost: PHP" + totalPrice +
                                ".\n" + "Quantity: " + quantity + "\nCurrent balance: PHP" + accountBalance);
                    }else{
                        showMessage("Insufficient funds. Please add more money.\nCurrent balance: PHP" + accountBalance);
                    }
                }catch(NumberFormatException ex){
                    showMessage("Invalid quantity. Please enter a valid number.");
                }
            }
        });
        
        addBalanceBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String amountToAddString = JOptionPane.showInputDialog("Enter the amount to add (PHP): (Limit = " +
                            "PHP5000.00)");
                    double amountToAdd = Double.parseDouble(amountToAddString);
                    if(amountToAdd > 5000) showMessage("Please input amount less than PHP5000.");
                    else if(amountToAdd < 0) showMessage("Please don't input negative numbers.");
                    else addMoney(amountToAdd);
                }catch(NumberFormatException ex){
                    showMessage("Invalid input. Enter a valid number.");
                }
            }
        });
        
        checkBalanceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(menuFrame, "Current Balance: PHP" + accountBalance, "Current Balance",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        priceListBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(menuFrame, "Garena Shells - PHP20.00\nRiot Points - PHP30.00\nGenesis " +
                                "Crystals - PHP40.00\nRazer Pins - PHP50.00", "Price List",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
                mainMenu();
            }
        });
        
        exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int result = JOptionPane.showConfirmDialog(menuFrame,
                        "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                
                if (result == JOptionPane.YES_OPTION){
                    System.exit(0);
                }else{
                    menuFrame.dispose();
                    menuFrame.setVisible(true);
                }
            }
        });
    }
    
    private static void showPhoneMenu(){
        JFrame menuFrame = new JFrame("7-11 Loading Station");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new BoxLayout(menuFrame.getContentPane(), BoxLayout.Y_AXIS));
        menuFrame.setSize(400, 400);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        JLabel buyGameLoadLabel = new JLabel("Buy Phone Load", SwingConstants.CENTER);
        buyGameLoadLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        mainPanel.add(buyGameLoadLabel, BorderLayout.NORTH);
        JLabel selectProductLabel = new JLabel("Select product", SwingConstants.CENTER);
        JLabel enterQuantityLabel = new JLabel("Enter Quantity", SwingConstants.CENTER);
        JLabel enterYourNoLabel = new JLabel("Enter your phone number", SwingConstants.CENTER);
        JComboBox<String> productComboBox = new JComboBox<>(new String[]{"Smart", "DITO", "Globe",
                "TNT", "SKT"});
        JTextField quantityField = new JTextField(10);
        JTextField phoneNoField = new JTextField(20);
        JButton purchaseBtn = new JButton("Purchase");
        JButton addBalanceBtn = new JButton("Add Balance");
        JButton checkBalanceBtn = new JButton("Check Balance");
        JButton backBtn = new JButton("Go Back");
        JButton exitBtn = new JButton("Exit");
        
        //edit ng button
        selectProductLabel.setAlignmentX(0.5f);
        productComboBox.setMinimumSize(new Dimension(130, 20));
        productComboBox.setMaximumSize(new Dimension(130, 20));
        enterQuantityLabel.setAlignmentX(0.5f);
        quantityField.setMinimumSize(new Dimension(140, 20));
        quantityField.setMaximumSize(new Dimension(140, 20));
        enterYourNoLabel.setAlignmentX(0.5f);
        phoneNoField.setMaximumSize(new Dimension(150, 50));
        phoneNoField.setMinimumSize(new Dimension(150, 50));
        phoneNoField.setAlignmentX(0.5f);
        purchaseBtn.setMaximumSize(new Dimension(150, 50));
        purchaseBtn.setMinimumSize(new Dimension(150, 50));
        purchaseBtn.setAlignmentX(0.5f);
        addBalanceBtn.setMaximumSize(new Dimension(150, 50));
        addBalanceBtn.setMinimumSize(new Dimension(150, 50));
        addBalanceBtn.setAlignmentX(0.5f);
        checkBalanceBtn.setMaximumSize(new Dimension(150, 50));
        checkBalanceBtn.setMinimumSize(new Dimension(150, 50));
        checkBalanceBtn.setAlignmentX(0.5f);
        backBtn.setMinimumSize(new Dimension(150, 50));
        backBtn.setMaximumSize(new Dimension(150, 50));
        backBtn.setAlignmentX(0.5f);
        exitBtn.setMaximumSize(new Dimension(150, 50));
        exitBtn.setMinimumSize(new Dimension(150, 50));
        exitBtn.setAlignmentX(0.5f);
        
        //add na yung mga dineclare sa panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(selectProductLabel);
        buttonPanel.add(productComboBox);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(enterQuantityLabel);
        buttonPanel.add(quantityField);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(enterYourNoLabel);
        buttonPanel.add(phoneNoField);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(purchaseBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        buttonPanel.add(addBalanceBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(checkBalanceBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(backBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        buttonPanel.add(exitBtn);
        
        //iadd yung panel sa mainPanel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setContentPane(mainPanel);
        menuFrame.setVisible(true);
        
        purchaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String selectedProduct = (String) productComboBox.getSelectedItem();
                int quantity;
                String phoneNum;
                try{
                    quantity = Integer.parseInt(quantityField.getText());
                    phoneNum = phoneNoField.getText();
                    double totalPrice = calculateTotalPricePhone(selectedProduct, quantity);
                    if(totalPrice <= accountBalance && phoneNum.length() == 11 && phoneNum.startsWith("09")) {
                        accountBalance -= totalPrice;
                        showMessage("Successfully purchased " + selectedProduct + " Load!\nPhone Number: " + phoneNum +
                                "\nTotal" + " cost: PHP" + (totalPrice) +
                                "\nService fee: PHP" + serviceFee +
                                "\nQuantity: " + quantity +
                                "\nCurrent balance: PHP" + accountBalance);
                    }else{
                        if(!phoneNum.startsWith("09") || phoneNum.length() != 11) showMessage("Invalid phone number.");
                        else showMessage("Insufficient funds. Please add more money.\nCurrent balance: PHP" + accountBalance);
                    }
                }catch(NumberFormatException ex){
                    showMessage("Invalid quantity. Please enter a valid number.");
                }
            }
        });
        
        addBalanceBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String amountToAddString = JOptionPane.showInputDialog("Enter the amount to add (PHP): (Limit = " +
                            "PHP5000.00)");
                    double amountToAdd = Double.parseDouble(amountToAddString);
                    if(amountToAdd > 5000) showMessage("Please input amount less than PHP5000.");
                    else if(amountToAdd < 0) showMessage("Please don't input negative numbers.");
                    else addMoney(amountToAdd);
                }catch(NumberFormatException ex){
                    showMessage("Invalid input. Enter a valid number.");
                }
            }
        });
        
        checkBalanceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(menuFrame, "Current Balance: PHP" + accountBalance, "Current Balance",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
                mainMenu();
            }
        });
        
        exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int result = JOptionPane.showConfirmDialog(menuFrame,
                        "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                
                if (result == JOptionPane.YES_OPTION){
                    System.exit(0);
                }else{
                    menuFrame.dispose();
                    menuFrame.setVisible(true);
                }
            }
        });
    }
    
    private static void addMoney(double amount) {
        accountBalance += amount;
        JOptionPane.showMessageDialog(null,
                "Added PHP" + amount + ".\nCurrent balance: PHP" + accountBalance, "Add Load", JOptionPane
                        .INFORMATION_MESSAGE);
    }
    
    private static double calculateTotalPriceGame(String product, int quantity) {
        double price = 0;
        switch (product){
            case "Garena Shells":
                price = 20;
                break;
            case "Riot Points":
                price = 30;
                break;
            case "Genesis Crystals":
                price = 40;
                break;
            case "Razer Pins":
                price = 50;
                break;
        }
        return price * quantity;
    }
    
    private static double calculateTotalPricePhone(String product, int quantity) {
        double price = 0;
        switch (product){
            case "Smart", "DITO", "Globe", "TNT", "SKT":
                price = 1;
                break;
        }
        return (price * quantity) + serviceFee;
    }
    
    private static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}