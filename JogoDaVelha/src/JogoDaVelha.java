
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class JogoDaVelha extends javax.swing.JFrame {

	private static final Color COLOR_WINNER = new java.awt.Color(120, 255, 120);
	private static final Color COLOR_BOX = new java.awt.Color(255, 255, 255);
	private boolean jogadorX = true; // Alterna entre o jogador X e O
	private final JButton[] botoes = new JButton[9]; // Para armazenar os botões do tabuleiro
	private JLabel statusJogo; // Para exibir o status do jogo (quem venceu ou empate)
	private boolean endGame;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	
	private JButton botaoReiniciar;
	private JLabel jLabel1;
	private javax.swing.JPanel jPanel2;
	// End of variables declaration//GEN-END:variables

	public JogoDaVelha() {
		

		statusJogo = new JLabel("Boa Sorte");		
		
		for (int i = 0; i < botoes.length; i++) {
			
			JButton atual = new JButton();
			atual.setBackground(COLOR_BOX);
			atual.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
			atual.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (atual.getText().equals("") && !endGame) { // Verifica se o botão está vazio
						atual.setText(jogadorX ? "X" : "O");
						jogadorX = !jogadorX; // Alterna o jogador
						verificarVencedor(); // Verifica se há um vencedor
					}
				}
			});
			botoes[i] = atual;
			
		}
		
		initComponents();

	}
	
	private String verificaLinha(int a,int b, int c) {
		boolean vazios = botoes[a].getText().isEmpty() || botoes[b].getText().isEmpty() || botoes[c].getText().isEmpty();
		boolean ab = botoes[a].getText().equals(botoes[b].getText());
		boolean bc = botoes[b].getText().equals(botoes[c].getText());
		if(!vazios && ab && bc) {
			botoes[a].setBackground(COLOR_WINNER);
			botoes[b].setBackground(COLOR_WINNER);
			botoes[c].setBackground(COLOR_WINNER);
			
			botoes[a].revalidate();
			botoes[b].revalidate();
			botoes[c].revalidate();
			
			botoes[a].repaint();
			botoes[b].repaint();
			botoes[c].repaint();
			
			return botoes[a].getText();
		}
		return null;
	}

	// função verificarVencedor()
	private void verificarVencedor() {
		
		// Verifica linhas		
		declararVencedor(verificaLinha(0, 1, 2));
		declararVencedor(verificaLinha(3, 4, 5));
		declararVencedor(verificaLinha(6, 7, 8));

		// Verifica colunas
		declararVencedor(verificaLinha(0, 3, 6));
		declararVencedor(verificaLinha(1, 4, 7));
		declararVencedor(verificaLinha(2, 5, 8));

		// Verifica diagonais
		declararVencedor(verificaLinha(0, 4, 8));
		declararVencedor(verificaLinha(2, 4, 6));

		// Verifica se houve empate (tabuleiro cheio)
		boolean empate = true;
		for (int i = 0; i < botoes.length; i++) {
			if (botoes[i].getText().equals("")) {
				empate = false;
				break;
			}
		}

		if (empate) {
			statusJogo.setText("Empate!");
			fimDeJogo();
		}
	}

	// Função para Declarar o Vencedor
	private void declararVencedor(String jogador) {
		if(jogador != null) {
			statusJogo.setText("Jogador " + jogador + " venceu!");
			fimDeJogo(); // Desativa o tabuleiro após a vitória
		}
	}

	// Função para Desativar o Tabuleiro
	private void fimDeJogo() {
		endGame = true;
	}

	

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new JLabel();
		botaoReiniciar = new JButton();
		jPanel2 = new javax.swing.JPanel();
		

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("JOGO DA VELHA");

		jLabel1.setText("Jogador  X  Começa ");

		botaoReiniciar.setBackground(new java.awt.Color(0, 153, 51));
		botaoReiniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		botaoReiniciar.setText("Reiniciar");
		botaoReiniciar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoReiniciarActionPerformed(evt);
			}
		});

		jPanel2.setLayout(new java.awt.GridLayout(3, 3));

		

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(botaoReiniciar, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addGap(28, 28, 28))
				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(botoes[0], GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
								.addComponent(botoes[3], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(botoes[6], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(1, 1, 1)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(botoes[4], GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(botoes[1], GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(botoes[7], GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
						.addGap(1, 1, 1)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(botoes[5], GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(botoes[2], GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(botoes[8], GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE).addComponent(
								botaoReiniciar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(botoes[2], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(botoes[0], GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(botoes[1], GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
				.addGap(1, 1, 1)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(botoes[3], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(botoes[4], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(botoes[5], GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
				.addGap(1, 1, 1)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
						.addComponent(botoes[6], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(botoes[7], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(botoes[8], GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	

	private void botaoReiniciarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoReiniciarActionPerformed

		for (int i = 0; i < botoes.length; i++) {
			botoes[i].setText(""); // Limpa o texto dos botões
			botoes[i].setBackground(COLOR_BOX);
		}
		statusJogo.setText("Jogador X começa"); // Reseta o status
		jogadorX = true; // Reinicia com o jogador X
		endGame = false;

	}// GEN-LAST:event_botaoReiniciarActionPerformed

	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JogoDaVelha().setVisible(true);
			}
		});
	}

	
}
