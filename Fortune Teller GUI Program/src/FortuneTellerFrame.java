import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readFortuneButton;
    private JButton quitButton;

    private ArrayList<String> fortunes;
    private int previousIndex;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel
        ImageIcon fortuneTellerIcon = new ImageIcon("fortune_teller_icon.png");
        titleLabel = new JLabel("Fortune Teller", fortuneTellerIcon, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Middle panel
        fortuneArea = new JTextArea(10, 30);
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel
        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.addActionListener((ActionEvent e) -> readFortune());
        quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initialize fortunes
        fortunes = new ArrayList<>();
        fortunes.add("Fortune 1: You will find joy in unexpected places.");
        fortunes.add("Fortune 2: A pleasant surprise is in store for you.");
        fortunes.add("Fortune 3: Good things will come to you in due time.");
        fortunes.add("Fortune 4: You will make a new friend this week.");
        fortunes.add("Fortune 5: An exciting opportunity will arise soon.");
        fortunes.add("Fortune 6: Today is your lucky day!");
        fortunes.add("Fortune 7: You will receive a gift from an unexpected source.");
        fortunes.add("Fortune 8: A long-awaited dream will finally come true.");
        fortunes.add("Fortune 9: Your hard work will pay off handsomely.");
        fortunes.add("Fortune 10: You will travel to a faraway land in the near future.");
        fortunes.add("Fortune 11: Someone special will enter your life soon.");
        fortunes.add("Fortune 12: Your creativity will bring you success.");
        fortunes.add("Fortune 13: Trust your instincts; they will lead you to success.");
        fortunes.add("Fortune 14: Your kindness will be rewarded.");
        fortunes.add("Fortune 15: A new beginning is on the horizon for you.");
        fortunes.add("Fortune 16: You will overcome obstacles with ease.");
        fortunes.add("Fortune 17: A big surprise is in store for you.");
        fortunes.add("Fortune 18: Happiness is just around the corner.");
        fortunes.add("Fortune 19: Believe in yourself; you are capable of great things.");
        fortunes.add("Fortune 20: Love is in the air for you.");

        // Set previousIndex to -1 to indicate no fortune has been shown yet
        previousIndex = -1;

        // Set frame size and center it on screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width * 3 / 4;
        int height = screenSize.height;
        setSize(width, height);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void readFortune() {
        int index;
        do {
            index = new Random().nextInt(fortunes.size());
        } while (index == previousIndex);

        String fortune = fortunes.get(index);
        fortuneArea.append(fortune + "\n");
        previousIndex = index;
    }

    public static void main(String[] args) {
        new FortuneTellerFrame();
    }
}
