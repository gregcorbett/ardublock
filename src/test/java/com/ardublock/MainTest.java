package com.ardublock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedHashSet;
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
        File abpFileDirectory = new File("src/test/resources/examples");
        // List the .abp files in abpFileDirectory
        File[] abpFiles = abpFileDirectory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".abp");
            }
        });
        
        for (int i = 0; i < abpFiles.length; i++) {
            String abpFile = abpFiles[i].getAbsolutePath();
            String inoFile = abpFile.split("\\.")[0] + ".ino";

            // Generate C code from the .abp file.
            translator.reset();
            File file = new File(abpFile);
            context.loadArduBlockFile(file);
            LinkedHashSet<RenderableBlock> loopBlockSet = translator.findEntryBlocks();
            LinkedHashSet<RenderableBlock> subroutineBlockSet = translator.findSubroutineBlocks();
            
            String generatedCode = translator.translate(loopBlockSet, subroutineBlockSet);
            String expectedCode = new Scanner(new File(inoFile)).useDelimiter("\\Z").next();
            
            if (generatedCode.equals(expectedCode)) {
                System.out.println(abpFile + " passing");
            }
            else {
                System.out.println("Failing on " + abpFile);
                System.out.println("Expected code");
                System.out.println(expectedCode);
                System.out.println("Generated code");
                System.out.println(generatedCode);
                System.exit(-1);
            }

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace(); // To try and minimise concurrent access errors
            }
        }
        
    }
    
}
