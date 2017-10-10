package com.ardublock.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import com.ardublock.core.Context;
import com.ardublock.translator.AutoFormat;

import edu.mit.blocks.workspace.Workspace;

public class EraseButtonListener implements ActionListener
{
	private JFrame parentFrame;
	private Context context;
	private Workspace workspace; 
	private ResourceBundle uiMessageBundle;
	
	public EraseButtonListener(JFrame frame, Context context)
	{
		this.parentFrame = frame;
		this.context = context;
		workspace = context.getWorkspaceController().getWorkspace();
		uiMessageBundle = ResourceBundle.getBundle("com/ardublock/block/ardublock");
	}
	
	public void actionPerformed(ActionEvent e)
	{
        AutoFormat formatter = new AutoFormat();
        String codeOut = "void setup() {\n"
                       + "// put your setup code here, to run once:\n\n"
                       + "}\n\n"
                       + "void loop() {\n"
                       + "// put your main code here, to run repeatedly:\n\n"
                       + "}";
        
        if (context.isNeedAutoFormat)
        {
            codeOut = formatter.format(codeOut);
        }
        
        if (!context.isInArduino())
        {
            System.out.println(codeOut);
        }		
        context.didGenerate(codeOut);
	}
}
