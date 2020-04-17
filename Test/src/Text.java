import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Text extends JFrame {
	int count[] = {0, 0, 0};
	String show = "";
	String menu[] = {"햄버거", "콜라", "껌"};
	String coin[] = {"50000", "10000", "5000", "1000", "500", "100", "50", "10"};
	String namelist[] = {"햄버거 1000원", "  콜라 500원", "  껌 300원"};
	int price[] = {1000, 500, 300};
	int money;
	
	public Text()
	{
		
		/**프레임 설정**/
		JFrame frame = new JFrame("자동 판매기 프로그램");
		frame.setLayout(new BorderLayout());
		frame.setBounds(0, 0, 600, 1000);
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/**프레임 설정 완료**/
		
		/**위쪽 패널 설정**/
		//Up 설정
		JPanel Up = new JPanel();
		Up.setLayout(null);
		Up.setBackground(Color.ORANGE);
		Up.setPreferredSize(new Dimension(600, 300));
		frame.pack();
		
		JButton bt[] = new JButton[3];
		Button plus[] = new Button[3];
		Button minus[] = new Button[3];
		JTextField suja[] = new JTextField[5];
		ImageIcon icon[] = new ImageIcon[5];
		JLabel name[] = new JLabel[3];
		
		for(int i=0; i<3; i++)
		{
			bt[i] = new JButton(menu[i]);
			bt[i].setBounds(80 + i * 150, 50, 100, 100);
			icon[i] = new ImageIcon("Images/"+i+".jpg");
			bt[i].setIcon(icon[i]);
			
			suja[i] = new JTextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
			suja[i].setEnabled(false);
			
			plus[i] = new Button("+");
			plus[i].setEnabled(false);
			plus[i].setBounds(suja[i].getX() + 50, suja[i].getY()-0, 10, 10);
			
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
		
		frame.add("North", Up);
		/**위쪽 패널 설정 완료**/
		
		/**중간 패널 설정**/
		JPanel Mid = new JPanel();
		Mid.setLayout(null);
		Mid.setBackground(Color.ORANGE);
		Mid.setPreferredSize(new Dimension(600, 400));
		frame.pack();
		
		JTextField have1 = new JTextField();
		have1 = new JTextField(" 현재 금액");
		have1.setBounds(100, 50, 60, 30);
		have1.setEnabled(false);
		
		JTextField have2 = new JTextField();
		have2.setBounds(have1.getX()+60, have1.getY(), 150, 30);
		
		JButton start = new JButton("시작");
		start.setBounds(have2.getX()+200, have2.getY()-5, 60, 40);
		
		JLabel total1 = new JLabel("  합계");
		total1.setBounds(have1.getX()+10, have1.getY()+60, 60, 30);
		
		JTextField total2 = new JTextField();
		total2.setBounds(total1.getX()+50, total1.getY(), 150, 30);
		total2.setEnabled(false);
		
		JButton pay = new JButton("구매");
		pay.setEnabled(false);
		pay.setBounds(total2.getX()+200, total2.getY()-5, 60, 40);
		
		JButton reset = new JButton("초기화");
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
		/**중간 패널 설정 완료**/
		
		/** 아래쪽 패널 설정 **/
		JPanel Down = new JPanel();
		Down.setLayout(null);
		Down.setBackground(Color.ORANGE);
		Down.setPreferredSize(new Dimension(600, 200));
		frame.pack();
		
		JLabel rm[] = new JLabel[8];
		JLabel rmm = new JLabel("거스름돈");
		rmm.setBounds(250, 0, 100, 30);
		Down.add(rmm);
		JTextField rs[] = new JTextField[8];
		
		for(int i=0; i<8; i++)
		{
			rm[i] = new JLabel(coin[i]);
			rm[i].setBounds(50+(i*60), 30, 40, 30);
			
			rs[i] = new JTextField();
			rs[i].setEnabled(false);
			rs[i].setBounds(rm[i].getX(), rm[i].getY()+30, 40, 30);
			
			Down.add(rm[i]);
			Down.add(rs[i]);
		}
		
		frame.add("South", Down);
		frame.setVisible(true);
		/**아래쪽 패널 설정 완료**/
		
		//시작 버튼 이벤트 설정
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				money = Integer.parseInt(have2.getText());
				if(money>0 && money<=50000)
				{
					for(int i=0; i<3; i++)
					{
						plus[i].setEnabled(true);
						minus[i].setEnabled(true);
						suja[i].setText("0");
					}
					pay.setEnabled(true);
					have2.setEditable(false);
					reset.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"다시 지폐를 넣어주세요(1~50000)");
				}
				start.setEnabled(false);
			}
		});
		
		//엔터키로 금액 입력 받기
		have2.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e)
		    {
				if(e.getKeyChar() == '\n')
				{
					money = Integer.parseInt(have2.getText());
					if(money>0 && money<=50000)
					{
						for(int i=0; i<3; i++)
						{
							plus[i].setEnabled(true);
							minus[i].setEnabled(true);
							suja[i].setText("0");
						}
						pay.setEnabled(true);
						have2.setEditable(false);
						reset.setEnabled(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"다시 지폐를 넣어주세요(1~50000)");
					}
					start.setEnabled(false);
				}
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
		
		//증감버튼 이벤트 설정
		for(int i=0; i<3; i++)
		{	
			int j = i;
			plus[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					count[j] = count[j]+1;
					suja[j].setText(count[j] + "");
					total2.setText(Integer.toString((count[0]*price[0])+(count[1]*price[1]) + (count[2]*price[2])));
				}
			});
			
			minus[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					if(count[j] > 0) {
						count[j] = count[j]-1;
						suja[j].setText(count[j]+"");
						total2.setText(Integer.toString((count[0]*price[0])+(count[1]*price[1]) + (count[2]*price[2])));
						}
					}
				});
			}
		
		//구매 버튼 설정
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int result = (count[0]*price[0])+(count[1]*price[1]) + (count[2]*price[2]);
				int mok[] = {0, 0, 0, 0, 0, 0, 0, 0};
				int Coin[] = {0, 0, 0, 0, 0, 0, 0, 0};
				
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
							result = result - mok[i]*Coin[i];
						}
						rs[i].setText(Integer.toString(mok[i]));
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"돈이 모자랍니다...");
				}
			}
		});
		
		//초기화 버튼 설정
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				for(int i=0; i<3; i++)
				{
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
			}
		});
	}

	public static void main(String[] args)
	{
		new Text();
	}
}
