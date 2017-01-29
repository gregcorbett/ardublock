package com.ardublock;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.ardublock.core.Context;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNameDuplicatedException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

import edu.mit.blocks.renderable.RenderableBlock;
import edu.mit.blocks.workspace.Workspace;

import org.testng.annotations.*;

public class MainTest
{
	private Main main;
	private Translator translator;
	private Context context;
    
	private void teardown() {
		main.shutdown();
    }
    
	@BeforeClass
	public void setUp() throws SAXException, IOException, ParserConfigurationException
	{
		System.out.println("### setUp()");
		main = new Main();
		main.startArdublock();
		context = Context.getContext();
		Workspace workspace = context.getWorkspaceController().getWorkspace();
		translator = new Translator(workspace);
    }
	
	@Test
	public void testFiles() throws SAXException, IOException, ParserConfigurationException, SubroutineNameDuplicatedException, SocketNullException, SubroutineNotDeclaredException
	{
		System.out.println("### testFiles");
        String abpFiles[] = {
            "src/test/resources/examples/satellite-part1.abp",
            "src/test/resources/examples/satellite-part2.abp",
            "src/test/resources/examples/satellite-part3.abp",
            "src/test/resources/examples/satellite-part4.abp",
        };

        String inoFiles[] = {
            "src/test/resources/examples/satellite-part1.ino",
            "src/test/resources/examples/satellite-part2.ino",
            "src/test/resources/examples/satellite-part3.ino",
            "src/test/resources/examples/satellite-part4.ino",
        };
        
        for (int i = 0; i < abpFiles.length; i++) {
            String apbFile = abpFiles[i];
            String inoFile = inoFiles[i];
            translator.reset();
            File file = new File(apbFile);
            context.loadArduBlockFile(file);
            Set<RenderableBlock> loopBlockSet = translator.findEntryBlocks();
            Set<RenderableBlock> subroutineBlockSet = translator.findSubroutineBlocks();
            
            String generatedCode = translator.translate(loopBlockSet, subroutineBlockSet);
            String expectedCode = new Scanner(new File(inoFile)).useDelimiter("\\Z").next();
            
            if (!generatedCode.equals(expectedCode)) {
                System.out.println("Failing on " + apbFile);
                System.out.println("======================================");
                System.out.println(generatedCode);
                System.out.println("======================================");
                System.out.println(expectedCode);
                System.exit(-1);
            }
            else {
                System.out.println(apbFile + " passing");
            }

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace(); // To try and minimise concurrent access errors
            }
        }
        
    }
    
}
