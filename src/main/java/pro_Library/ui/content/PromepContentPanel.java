package pro_Library.ui.content;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import pro_Library.dto.Memberp;
import pro_Library.service.ProfileService;
import pro_Library.ui.exception.InvalidCheckException;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class PromepContentPanel extends AbstractContentPanel<Memberp> {
	private JTextField tfm_pNo;
	private JTextField tfm_id;

	public PromepContentPanel() {
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pme_pNo = new JPanel();
		add(pme_pNo, BorderLayout.NORTH);
		pme_pNo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tfm_pNo = new JTextField();
		tfm_pNo.setColumns(10);
		pme_pNo.add(tfm_pNo);
		
		JLabel lbm_pNo2 = new JLabel("회원님 안녕하세요.");
		pme_pNo.add(lbm_pNo2);
		
		JPanel pme_id = new JPanel();
		add(pme_id, BorderLayout.CENTER);
		
		JLabel lbm_id1 = new JLabel("회원님의 ID는");
		pme_id.add(lbm_id1);
		
		tfm_id = new JTextField();
		pme_id.add(tfm_id);
		tfm_id.setColumns(10);
		
		JLabel lbm_id2 = new JLabel("입니다.");
		pme_id.add(lbm_id2);		
	}

	@Override
	public void setItem(Memberp item) {
		tfm_pNo.setText(String.valueOf(item.getpNo()));
		tfm_id.setText(item.getmID());

		tfm_pNo.setEditable(false);
		
	}

	@Override
	public Memberp getItem() {
		validCheck();
		int pNo = Integer.parseInt(tfm_pNo.getText().trim());
		String mID = tfm_id.getText().trim();
			
		return new Memberp(pNo, mID);
	}

	@Override
	public void validCheck() {
		if (tfm_pNo.getText().contentEquals("") || tfm_id.getText().equals("")) {
				throw new InvalidCheckException();
			}
		
	}

	@Override
	public void clearTf() {
		tfm_pNo.setText("");
		tfm_id.setText("");
		
		if (!tfm_pNo.isEditable()) {
			tfm_pNo.setEditable(true);

		}
		
	}

	public void setService(ProfileService servicep) {
		// TODO Auto-generated method stub
		
	}

	public void loadData() {
		// TODO Auto-generated method stub
		
	}

}
