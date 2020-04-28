import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Arrays;

public class Text extends JFrame {
	int Result[][] = new int[50001][8];
	int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	String[] menu = {"�ܹ���", "���", "���", "ź��", "Ŀ��", "��", "���", "����", "��"};
	String[] coin = {"50000", "10000", "5000", "1000", "500", "160", "50", "10"};
	String[] namelist = {"�ܹ��� 1500��", " ��� 2000��", " ��� 1000��", "  ź�� 800��", "  Ŀ�� 700��", "  �� 600��", "  ��� 500��", "  ���� 600��", "   �� 300��"};
	int[] price = {1500, 2000, 1000, 800, 700, 600, 500, 600, 300};
	int money;
	
	public Text()
	{
		
		/**������ ����**/
		JFrame frame = new JFrame("�ڵ� �Ǹű� ���α׷�");
		frame.setLayout(new BorderLayout());
		frame.setBounds(0, 0, 600, 1000);
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/**������ ���� �Ϸ�**/
		
		
		/**JTabbedPane ����**/
		JTabbedPane jt = new JTabbedPane();
		jt.setBackground(Color.gray);
		jt.setPreferredSize(new Dimension(600, 300));
		frame.pack();
		/**JTabbedPane ���� �Ϸ�**/
		
		
		
		/**���� �г�(�⺻ �Ļ��) ����**/
		//Up ����
		JPanel Up = new JPanel();
		Up.setLayout(null);
		Up.setBackground(Color.pink);
		Up.setPreferredSize(new Dimension(600, 300));
		frame.pack();
		
		JButton[] bt = new JButton[9];
		Button[] plus = new Button[9];
		Button[] minus = new Button[9];
		JTextField[] suja = new JTextField[9];
		ImageIcon[] icon = new ImageIcon[9];
		JLabel[] name = new JLabel[9];
		
		for(int i=0; i<3; i++)
		{
			bt[i] = new JButton(menu[i]);
			bt[i].setBounds(100 + i * 150, 50, 100, 100);
			
			URL urlImage = getClass().getResource((i+1)+".jpg");
			icon[i] = new ImageIcon(urlImage);
			bt[i].setIcon(new imgresize().resize(icon[i]));
			
			suja[i] = new JTextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
			suja[i].setEnabled(false);
			suja[i].setDisabledTextColor(Color.BLACK.darker());
			
			plus[i] = new Button("+");
			plus[i].setEnabled(false);
			plus[i].setBounds(suja[i].getX() + 50, suja[i].getY(), 10, 10);
			
			minus[i] = new Button("-");
			minus[i].setEnabled(false);
			minus[i].setBounds(suja[i].getX() + 50, suja[i].getY()+10, 10, 10);
			
			name[i] = new JLabel(namelist[i]);
			name[i].setBounds(bt[i].getX()+15, bt[i].getY()-30, 100, 20);
			
			Up.add(bt[i]);
			Up.add(suja[i]);
			Up.add(plus[i]);
			Up.add(minus[i]);
			Up.add(name[i]);
		}
		
		jt.addTab("�⺻ �Ļ��", Up);
		/**���� �г� ���� �Ϸ�**/
		
		/**���� �г�(���� �ڳ�) ����**/
		//Up ����
		JPanel Up2 = new JPanel();
		Up2.setLayout(null);
		Up2.setBackground(Color.pink);
		Up2.setPreferredSize(new Dimension(600, 300));
		frame.pack();
		
		for(int i=3; i<6; i++)
		{
			bt[i] = new JButton(menu[i]);
			bt[i].setBounds(100 + (i-3) * 150, 50, 100, 100);
			URL urlImage = getClass().getResource((i+1)+".jpg");
			icon[i] = new ImageIcon(urlImage);
			bt[i].setIcon(icon[i]);
			bt[i].setIcon(new imgresize().resize(icon[i]));



			suja[i] = new JTextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
			suja[i].setEnabled(false);
			suja[i].setDisabledTextColor(Color.BLACK.darker());

			
			plus[i] = new Button("+");
			plus[i].setEnabled(false);
			plus[i].setBounds(suja[i].getX() + 50, suja[i].getY(), 10, 10);
			
			minus[i] = new Button("-");
			minus[i].setEnabled(false);
			minus[i].setBounds(suja[i].getX() + 50, suja[i].getY()+10, 10, 10);
			
			name[i] = new JLabel(namelist[i]);
			name[i].setBounds(bt[i].getX()+15, bt[i].getY()-30, 100, 20);
			
			Up2.add(bt[i]);
			Up2.add(suja[i]);
			Up2.add(plus[i]);
			Up2.add(minus[i]);
			Up2.add(name[i]);
		}
		
		jt.addTab("���� �ڳ�", Up2);
		/**���� �г� ���� �Ϸ�**/
		
		/**���� �г�(���� �ڳ�) ����**/
		//Up3 ����
		JPanel Up3 = new JPanel();
		Up3.setLayout(null);
		Up3.setBackground(Color.pink);
		Up3.setPreferredSize(new Dimension(600, 300));
		frame.pack();
		
		for(int i=6; i<9; i++)
		{
			bt[i] = new JButton(menu[i]);
			bt[i].setBounds(100 + (i-6) * 150, 50, 100, 100);
			URL urlImage = getClass().getResource((i+1)+".jpg");
			icon[i] = new ImageIcon(urlImage);
			bt[i].setIcon(icon[i]);
			bt[i].setIcon(new imgresize().resize(icon[i]));

			suja[i] = new JTextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
			suja[i].setEnabled(false);
			suja[i].setDisabledTextColor(Color.BLACK.darker());

			plus[i] = new Button("+");
			plus[i].setEnabled(false);
			plus[i].setBounds(suja[i].getX() + 50, suja[i].getY(), 10, 10);
			
			minus[i] = new Button("-");
			minus[i].setEnabled(false);
			minus[i].setBounds(suja[i].getX() + 50, suja[i].getY()+10, 10, 10);
			
			name[i] = new JLabel(namelist[i]);
			name[i].setBounds(bt[i].getX()+15, bt[i].getY()-30, 100, 20);
			
			Up3.add(bt[i]);
			Up3.add(suja[i]);
			Up3.add(plus[i]);
			Up3.add(minus[i]);
			Up3.add(name[i]);
		}
		
		jt.addTab("���� �ڳ�", Up3);
		/**���� �г� ���� �Ϸ�**/
		
		frame.add("North", jt);
		
		/**�߰� �г� ����**/
		JPanel Mid = new JPanel();
		Mid.setLayout(null);
		Mid.setBackground(Color.ORANGE);
		Mid.setPreferredSize(new Dimension(600, 400));
		frame.pack();
		
		JTextField have1;
		have1 = new JTextField(" ���� �ݾ�");
		have1.setBounds(100, 50, 60, 30);
		have1.setEnabled(false);
		have1.setDisabledTextColor(Color.BLACK.darker());
		
		JTextField have2 = new JTextField();
		have2.setBounds(have1.getX()+60, have1.getY(), 150, 30);
		
		JButton start = new JButton("����");
		start.setBounds(have2.getX()+200, have2.getY()-5, 60, 40);
		
		JLabel total1 = new JLabel("  �հ�");
		total1.setBounds(have1.getX()+10, have1.getY()+60, 60, 30);
		
		JTextField total2 = new JTextField();
		total2.setBounds(total1.getX()+50, total1.getY(), 150, 30);
		total2.setEnabled(false);

		
		JButton pay = new JButton("����");
		pay.setEnabled(false);
		pay.setBounds(total2.getX()+200, total2.getY()-5, 60, 40);
		
		JButton reset = new JButton("�ʱ�ȭ");
		reset.setEnabled(false);
		reset.setBounds(pay.getX() + 100, pay.getY(), 100, 40);
		
		Mid.add(have1);
		Mid.add(have2);
		Mid.add(start);
		Mid.add(total1);
		Mid.add(total2);
		Mid.add(pay);
		Mid.add(reset);
		
		frame.add("Center", Mid);
		/**�߰� �г� ���� �Ϸ�**/
		
		/** �Ʒ��� �г� ���� **/
		JPanel Down = new JPanel();
		Down.setLayout(null);
		Down.setBackground(Color.ORANGE);
		Down.setPreferredSize(new Dimension(600, 200));
		frame.pack();
		
		JLabel[] rm = new JLabel[8];
		JLabel rmm = new JLabel("�Ž�����");
		rmm.setBounds(250, 0, 100, 30);
		Down.add(rmm);
		JTextField[] rs = new JTextField[8];
		
		for(int i=0; i<8; i++)
		{
			rm[i] = new JLabel(coin[i]);
			rm[i].setBounds(50+(i*60), 30, 40, 30);
			
			rs[i] = new JTextField();
			rs[i].setEnabled(false);
			rs[i].setBounds(rm[i].getX(), rm[i].getY()+30, 40, 30);
			rs[i].setDisabledTextColor(Color.BLACK.darker());

			Down.add(rm[i]);
			Down.add(rs[i]);
		}
		
		frame.add("South", Down);
		frame.setVisible(true);
		/**�Ʒ��� �г� ���� �Ϸ�**/
		
		//���� ��ư �̺�Ʈ ����
		start.addActionListener(e -> {
			money = Integer.parseInt(have2.getText());
			if(money%10 != 0)
			{
				JOptionPane.showMessageDialog(null,"����� ������ �Է����ּ���");
			}
			else if(money>0 && money<=50000)
			{
				for(int i=0; i<9; i++)
				{
					plus[i].setEnabled(true);
					minus[i].setEnabled(true);
					suja[i].setText("0");
				}
				pay.setEnabled(true);
				have2.setEditable(false);
				reset.setEnabled(true);
				start.setEnabled(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"�ٽ� ���� �־��ּ���(1~50000)");
			}
		});
		
		//����Ű�� �ݾ� �Է� �ޱ�
		have2.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e)
		    {
				if(e.getKeyChar() == '\n')
				{
					money = Integer.parseInt(have2.getText());
					if(money%10 != 0)
					{
						JOptionPane.showMessageDialog(null,"����� ������ �Է����ּ���");
					}
					else if(money>0 && money<=50000)
					{
						for(int i=0; i<9; i++)
						{
							plus[i].setEnabled(true);
							minus[i].setEnabled(true);
							suja[i].setText("0");
						}
						pay.setEnabled(true);
						have2.setEditable(false);
						reset.setEnabled(true);
						start.setEnabled(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"�ٽ� ���� �־��ּ���(1~50000)");
					}
				}
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
		
		//������ư �̺�Ʈ ����


		for(int i=0; i<9; i++)
		{	
			int j = i;
			plus[i].addActionListener(e -> {
				count[j] = count[j]+1;
				suja[j].setText(count[j] + "");
				total2.setText(Integer.toString((count[0]*price[0])+(count[1]*price[1]) + (count[2]*price[2])+ (count[3]*price[3])+ (count[4]*price[4])+ (count[5]*price[5])+ (count[6]*price[6])+ (count[7]*price[7])+ (count[8]*price[8])));
			});

			bt[i].addActionListener(e -> {
				if(start.isEnabled() == false){
				count[j] = count[j]+1;
				suja[j].setText(count[j] + "");
				total2.setText(Integer.toString((count[0]*price[0])+(count[1]*price[1]) + (count[2]*price[2])+ (count[3]*price[3])+ (count[4]*price[4])+ (count[5]*price[5])+ (count[6]*price[6])+ (count[7]*price[7])+ (count[8]*price[8])));
			}});

			minus[i].addActionListener(e -> {
				if(count[j] > 0) {
					count[j] = count[j]-1;
					suja[j].setText(count[j]+"");
					total2.setText(Integer.toString((count[0]*price[0])+(count[1]*price[1]) + (count[2]*price[2])+ (count[3]*price[3])+ (count[4]*price[4])+ (count[5]*price[5])+ (count[6]*price[6])+ (count[7]*price[7])+ (count[8]*price[8])));
					}
				});
			}
		
		//
		
		//���� ��ư ����
		pay.addActionListener(e -> {
			int Times[] = new int[50001];
			int result = money - ((count[0]*price[0])+(count[1]*price[1]) + (count[2]*price[2])+ (count[3]*price[3])+ (count[4]*price[4])+ (count[5]*price[5])+ (count[6]*price[6])+ (count[7]*price[7])+ (count[8]*price[8]));
			if(result < 0)
			{
				JOptionPane.showMessageDialog(null,"���� ���ڶ��ϴ�...");
			}
			int Money[] = new int[9];
			
			Arrays.fill(Times, 127);
			Times[0] = 0;
			
			Arrays.fill(Result[0],  0);
			
			for(int i=0; i<8; i++)
			{
				Money[i] = Integer.parseInt(coin[i]);
			}
			
			
			for(int i=0; i<=result; i++)
			{
				for(int j=0; j<8; j++)
				{
					if(Money[j]<=i && Times[i-Money[j]]+1 < Times[i])
					{
						Times[i] = Times[i-Money[j]] + 1;
						Result[i]= Arrays.copyOf(Result[i-Money[j]], Result[i].length);
						
						Result[i][j]++;
					}
				}
			}
			
			for(int i=0; i<8; i++)
			{
				rs[i].setText(Integer.toString(Result[result][i]));
			}
			
			/**
			int result = (count[0]*price[0])+(count[1]*price[1]) + (count[2]*price[2])+ (count[3]*price[3])+ (count[4]*price[4])+ (count[5]*price[5])+ (count[6]*price[6])+ (count[7]*price[7])+ (count[8]*price[8])-;
			int[] mok = {0, 0, 0, 0, 0, 0, 0, 0};
			int[] Coin = {0, 0, 0, 0, 0, 0, 0, 0};

			for(int i=0; i<8; i++)
			{
				Coin[i] = Integer.parseInt(coin[i]);
			}

			if(money >= result)
			{
				result = money - result;

				for(int i=0; i<coin.length; i++)
				{
					if(Coin[i] <= result)
					{
						mok[i]  = result/Coin[i];
						result = result%Coin[i];
					}
					rs[i].setText(Integer.toString(mok[i]));
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"���� ���ڶ��ϴ�...");
			}
			**/
		});
		
		//�ʱ�ȭ ��ư ����
		reset.addActionListener(e -> {
			for(int i=0; i<9; i++)
			{
				count[i] = 0;
				suja[i].setText("0");
				plus[i].setEnabled(false);
				minus[i].setEnabled(false);
			}
			for(int i=0; i<8; i++)
			{
				rs[i].setText("0");
			}
			start.setEnabled(true);
			have2.setText("0");
			have2.setEditable(true);
			total2.setText("0");
			pay.setEnabled(false);
			reset.setEnabled(false);
		});
		
		//������ ������ ���� (���� Ȯ��â ����)
		 frame.addWindowListener(new WindowListener() {
	            @Override
	            public void windowOpened(WindowEvent e) {
	            }

	            @Override
	            public void windowIconified(WindowEvent e) {
	            }

	            @Override
	            public void windowDeiconified(WindowEvent e) {
	            }

	            @Override
	            public void windowDeactivated(WindowEvent e) {
	            }

	            @Override
	            public void windowClosing(WindowEvent e) {
	            	int result = JOptionPane.showConfirmDialog(null,  "������ �����Ͻðڽ��ϱ�?", "��", JOptionPane.YES_NO_OPTION);
	            	if(result == 0) System.exit(0);
	            	else frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	            }

	            @Override
	            public void windowClosed(WindowEvent e) {
	            }

	            @Override
	            public void windowActivated(WindowEvent e) {
	                System.out.println("TestSwing.main(...).new WindowListener() {...}.windowActivated()");
	            }
	        });

	}

	public static void main(String[] args)
	{
		new Text();
	}
}
