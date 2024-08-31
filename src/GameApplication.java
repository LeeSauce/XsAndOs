import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameApplication extends JFrame implements ActionListener {
    private JLabel label;
    private Border border;
    private ImageIcon imageIcon;


    // realizing now I could have put all of this in an array... too lazy to change that now
    private JButton leftUpperButton;
    private JButton middleUpperButton;
    private JButton rightUpperButton;
    private JButton leftMiddleButton;
    private JButton middleButton;
    private JButton rightMiddleButton;
    private JButton leftLowerButton;
    private JButton middleLowerButton;
    private JButton rightLowerButton;


    private String setButtonText;

    private Game game;

    private boolean[] isEmpty = new boolean[]{false,false,false,false,false,false,false,false,false};
    public GameApplication() {
        this.game = new Game();

        this.leftUpperButton = new JButton();
        this.middleUpperButton = new JButton();
        this.rightUpperButton = new JButton();
        this.leftMiddleButton = new JButton();
        this.middleButton = new JButton();
        this.rightMiddleButton = new JButton();
        this.leftLowerButton = new JButton();
        this.middleLowerButton = new JButton();
        this.rightLowerButton = new JButton();



        this.label = new JLabel();

        this.imageIcon = new ImageIcon("gameIcon.jpeg");

        this.border = BorderFactory.createLineBorder(Color.GREEN,3); //This is using method factoring

        this.label.setBorder(border);

        this.setTitle("X's & O's");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 325);

        this.setIconImage(imageIcon.getImage());
        this.setResizable(false);
        this.setLayout(null);

        this.leftUpperButton.setBounds(1,25,100,90);
        this.leftUpperButton.addActionListener(this);
        this.add(this.leftUpperButton);

        this.middleUpperButton.setBounds(99,25,100,90);
        this.middleUpperButton.addActionListener(this);
        this.add(this.middleUpperButton);

        this.rightUpperButton.setBounds((99*2),25,100,90);
        this.rightUpperButton.addActionListener(this);
        this.add(this.rightUpperButton);

        this.leftMiddleButton.setBounds(1,25 + 90,100,90);
        this.leftMiddleButton.addActionListener(this);
        this.add(this.leftMiddleButton);

        this.middleButton.setBounds(99,25 + 90,100,90);
        this.middleButton.addActionListener(this);
        this.add(this.middleButton);

        this.rightMiddleButton.setBounds((99*2),25 + 90,100,90);
        this.rightMiddleButton.addActionListener(this);
        this.add(this.rightMiddleButton);

        this.leftLowerButton.setBounds(1,25 + 90 * 2,100,90);
        this.leftLowerButton.addActionListener(this);
        this.add(this.leftLowerButton);

        this.middleLowerButton.setBounds(99,25 + 90 * 2,100,90);
        this.middleLowerButton.addActionListener(this);
        this.add(this.middleLowerButton);

        this.rightLowerButton.setBounds((99*2),25 + 90 * 2,100,90);
        this.rightLowerButton.addActionListener(this);
        this.add(this.rightLowerButton);
        this.game.setAxis();
    }

    public void setLabelTurn(){
        this.label.setVerticalAlignment(JLabel.TOP);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setBounds(1,0,300,25);
        if(this.game.getIsOTurn()){
            this.label.setText("It's O's Turn!");
            this.setButtonText = "O";
        }else{
            this.label.setText("It's X's Turn!");
            this.setButtonText = "X";
        }
        this.add(this.label);
        this.revalidate();
    }

    public static void main(String[] args){
        GameApplication gameApplication = new GameApplication();
        gameApplication.setLabelTurn();

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leftUpperButton && !isEmpty[0]){
            this.game.move("1,1");
            leftUpperButton.setText(this.setButtonText);
            this.setLabelTurn();
        }
        if(e.getSource() == middleUpperButton && !isEmpty[1]){
            this.game.move("1,2");
            middleUpperButton.setText(this.setButtonText);
            this.setLabelTurn();

        }
    }


}


