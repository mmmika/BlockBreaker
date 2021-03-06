package com.dfour.blockbreaker.view;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.dfour.blockbreaker.BBModel;
import com.dfour.blockbreaker.BlockBreaker;

public class ShopScreen extends Scene2DScreen{

	private BBModel bbModel;
	private TextButton btnExBall;
	private TextButton btnExLazer;
	private TextButton btnExGuide;
	private TextButton btnExMPower;
	private TextButton btnExMStrength;
	private TextButton btnExRechargeRate;
	private TextButton btnMagBallOnly;
	private Label lblExBall;
	private Label lblExLazer;
	private Label lblExGuide;
	private Label lblExMPower;
	private Label lblExMStrength;
	private Label lblExRechargeRate;
	private Label lblExMagBallOnly;
	private Label lblExBallc;
	private Label lblExLazerc;
	private Label lblExGuidec;
	private Label lblExMPowerc;
	private Label lblExMStrengthc;
	private Label lblExRechargeRatec;
	private Label lblExMagBallOnlyc;
	private Label lblCash;
	private Label lblScore;
	private TextButton btnDone;
		
	public ShopScreen (BlockBreaker p, BBModel m){
		super(p);
		bbModel = m;
	}


	@Override
	public void show() {
		super.show();
		// make button and labels for extra ball, longer lazer, longer guide, mag power, mag strength
		btnExBall = new TextButton("$"+bbModel.calcCost(BBModel.EXTRA_BALL), skin);
		btnExBall.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent e, float x, float y) {
				super.clicked(e, x, y);
				if(bbModel.purchaseItem(BBModel.EXTRA_BALL)){
					btnExBall.setText("$"+bbModel.calcCost(BBModel.EXTRA_BALL));
					updateCash();
				}
				btnExBall.setChecked(false);
			}
		});
		
		btnExLazer = new TextButton("$"+bbModel.calcCost(BBModel.EXTRA_LAZER_TIME), skin);
		btnExLazer.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y){
				super.clicked(e, x, y);
				if(bbModel.purchaseItem(BBModel.EXTRA_LAZER_TIME)){
					btnExLazer.setText("$"+bbModel.calcCost(BBModel.EXTRA_LAZER_TIME));
					updateCash();
				}
				btnExLazer.setChecked(false);
			}
		});
		
		btnExGuide = new TextButton("$"+bbModel.calcCost(BBModel.EXTRA_G_LAZER_TIME), skin);
		btnExGuide.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y){
				super.clicked(e, x, y);
				if(bbModel.purchaseItem(BBModel.EXTRA_G_LAZER_TIME)){
					btnExGuide.setText("$"+bbModel.calcCost(BBModel.EXTRA_G_LAZER_TIME));
					updateCash();
				}
				btnExGuide.setChecked(false);
			}
		});
		
		btnExMPower = new TextButton("$"+bbModel.calcCost(BBModel.EXTRA_MAG_POWER), skin);
		btnExMPower.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y){
				super.clicked(e, x, y);
				if(bbModel.purchaseItem(BBModel.EXTRA_MAG_POWER)){
					btnExMPower.setText("$"+bbModel.calcCost(BBModel.EXTRA_MAG_POWER));
					updateCash();
				}
				btnExMPower.setChecked(false);
			}
		});
		
		btnExMStrength = new TextButton("$"+bbModel.calcCost(BBModel.EXTRA_MAG_STR), skin);
		btnExMStrength.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y){
				super.clicked(e, x, y);
				if(bbModel.purchaseItem(BBModel.EXTRA_MAG_STR)){
					updateCash();
					btnExMStrength.setText("$"+bbModel.calcCost(BBModel.EXTRA_MAG_STR));
				}
				btnExMStrength.setChecked(false);
			}
		});
		
		btnExRechargeRate = new TextButton("$"+bbModel.calcCost(BBModel.EXTRA_MAG_CHARGE), skin);
		btnExRechargeRate.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y){
				super.clicked(e, x, y);
				if(bbModel.purchaseItem(BBModel.EXTRA_MAG_CHARGE)){
					updateCash();
					btnExRechargeRate.setText("$"+bbModel.calcCost(BBModel.EXTRA_MAG_CHARGE));
				}
				btnExRechargeRate.setChecked(false);
			}
		});
		String magc = bbModel.lp.eternalMagBall?"Purchased":"$5000";
		btnMagBallOnly = new TextButton(magc,skin);
		btnMagBallOnly.setDisabled(!bbModel.lp.eternalMagBall);
		btnMagBallOnly.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				if(!bbModel.lp.eternalMagBall && bbModel.purchaseItem(BBModel.EXTRA_C_MAG_BALL) ){
					updateCash();
					btnMagBallOnly.setText("Purchased");
					lblExMagBallOnlyc.setText("Purchased");
					btnMagBallOnly.setDisabled(true);
				}
			}
			
		});
		
		btnDone = new TextButton("Done", skin);
		btnDone.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y){
				super.clicked(e, x, y);
				ShopScreen.this.returnScreen = BlockBreaker.APPLICATION;
				isReturning = true;	
				btnDone.setChecked(false);
			}
		});
		// label for score and cash
		lblScore = new Label("Score:"+bbModel.score,skin);
		lblCash = new Label("Cash: $"+bbModel.lp.cash,skin);
		
		lblExBall = new Label("Extra Life",skin);
		lblExLazer = new Label("Longer Lasting Lazer Drill",skin);
		lblExGuide = new Label("Longer Lasting Guide",skin);
		lblExMPower = new Label("More Magnet Power Storage",skin);
		lblExMStrength = new Label("Stronger Magnets",skin);
		lblExRechargeRate = new Label("Faster Magnet Power Recharge",skin);
		lblExMagBallOnly = new Label("Magnetic Balls",skin);
		
		lblExBallc = new Label(bbModel.lp.livesLeft+" Lives",skin);
		lblExLazerc = new Label(bbModel.lp.baseLazerTimer+" Seconds",skin);
		lblExGuidec = new Label(bbModel.lp.baseGuideLazerTimer+" Seconds",skin);
		lblExMPowerc = new Label(bbModel.lp.baseMagnetPower+" Units",skin);
		lblExMStrengthc = new Label(bbModel.lp.baseMagnetStrength+" Units",skin);
		lblExRechargeRatec = new Label(bbModel.lp.magnetRechargeRate*60+" Units per Second",skin);
		if(bbModel.lp.eternalMagBall){
			lblExMagBallOnlyc = new Label("Purchased",skin);
		}else{
			lblExMagBallOnlyc = new Label("Not Purchased",skin);
		}
		
		// label for cash
		updateCash();
		
        displayTable.add(lblExBall).uniformX().align(Align.left);
        displayTable.add(lblExBallc).uniformX().align(Align.right);
        displayTable.add().width(20f);
        displayTable.add(btnExBall).fillX().width(100);
        displayTable.row();
        displayTable.add(lblExLazer).uniformX().align(Align.left);
        displayTable.add(lblExLazerc).uniformX().align(Align.right);
        displayTable.add().width(20f);
        displayTable.add(btnExLazer).fillX().width(100);
        displayTable.row();
        displayTable.add(lblExGuide).uniformX().align(Align.left);
        displayTable.add(lblExGuidec).uniformX().align(Align.right);
        displayTable.add().width(20f);
        displayTable.add(btnExGuide).fillX().width(100);
        displayTable.row();
        displayTable.add(lblExMPower).uniformX().align(Align.left);
        displayTable.add(lblExMPowerc).uniformX().align(Align.right);
        displayTable.add().width(20f);
        displayTable.add(btnExMPower).fillX().width(100);
        displayTable.row();
        displayTable.add(lblExMStrength).uniformX().align(Align.left);
        displayTable.add(lblExMStrengthc).uniformX().align(Align.right);
        displayTable.add().width(20f);
        displayTable.add(btnExMStrength).fillX().width(100);
        displayTable.row();
        displayTable.add(lblExRechargeRate).uniformX().align(Align.left);
        displayTable.add(lblExRechargeRatec).uniformX().align(Align.right);
        displayTable.add().width(20f);
        displayTable.add(btnExRechargeRate).fillX().width(100);
        displayTable.row();
        displayTable.add(lblExMagBallOnly).uniformX().align(Align.left);
        displayTable.add(lblExMagBallOnlyc).uniformX().align(Align.right);
        displayTable.add().width(20f);
        displayTable.add(btnMagBallOnly).fillX().width(100);
        displayTable.row();
        displayTable.add(lblCash);
        displayTable.add(lblScore);
        displayTable.row();
        displayTable.add(btnDone).colspan(4).center();
        
	}

	private void updateCash() {
		lblCash.setText("Cash: $"+bbModel.lp.cash);
		lblScore.setText("Score: "+bbModel.score);
		lblExBallc.setText(bbModel.lp.livesLeft+" Lives");
		lblExLazerc.setText(bbModel.lp.baseLazerTimer+" Seconds");
		lblExGuidec.setText(bbModel.lp.baseGuideLazerTimer+" Seconds");
		lblExMPowerc.setText(bbModel.lp.baseMagnetPower+" Units");
		lblExMStrengthc.setText(bbModel.lp.baseMagnetStrength+" Units");
		lblExRechargeRatec.setText(bbModel.lp.magnetRechargeRate*60+" Units Per Second");
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		updateCash();
	}
}
