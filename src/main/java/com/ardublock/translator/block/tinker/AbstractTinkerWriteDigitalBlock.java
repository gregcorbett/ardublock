package com.ardublock.translator.block.tinker;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.DigitalOutputBlock;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public abstract class AbstractTinkerWriteDigitalBlock extends TranslatorBlock 
{

	AbstractTinkerWriteDigitalBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
		//translator.addHeaderFile("TinkerKit.h");
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String ret = "";
		
		String number = translatorBlock.toCode();

		if (translatorBlock instanceof NumberBlock)
		{
			String setupCode = "pinMode( " + number + ", OUTPUT);";
			translator.addSetupCommand(setupCode);
		}

		ret = "digitalWrite( ";
		ret = ret + number;
		
		ret = ret + " , ";
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		ret = ret + translatorBlock.toCode();
		ret = ret + " );\n";
		return ret;
	}
	
	
	

}
