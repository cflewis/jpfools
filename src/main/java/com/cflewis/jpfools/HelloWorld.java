package com.cflewis.jpfools;

import java.io.File;
import java.io.StringReader;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

// Copyright (C) 2010 United States Government as represented by the
// Administrator of the National Aeronautics and Space Administration
// (NASA).  All Rights Reserved.
//
// This software is distributed under the NASA Open Source Agreement
// (NOSA), version 1.3.  The NOSA has been approved by the Open Source
// Initiative.  See the file NOSA-1.3-JPF at the top of the distribution
// directory tree for the complete NOSA document.
//
// THE SUBJECT SOFTWARE IS PROVIDED "AS IS" WITHOUT ANY WARRANTY OF ANY
// KIND, EITHER EXPRESSED, IMPLIED, OR STATUTORY, INCLUDING, BUT NOT
// LIMITED TO, ANY WARRANTY THAT THE SUBJECT SOFTWARE WILL CONFORM TO
// SPECIFICATIONS, ANY IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR
// A PARTICULAR PURPOSE, OR FREEDOM FROM INFRINGEMENT, ANY WARRANTY THAT
// THE SUBJECT SOFTWARE WILL BE ERROR FREE, OR ANY WARRANTY THAT
// DOCUMENTATION, IF PROVIDED, WILL CONFORM TO THE SUBJECT SOFTWARE.
//

/**
 * you guess what that one does - just like a normal JVM
 */
public class HelloWorld {
	public void run() {
        String rules = "package com.cflewis.jpfools\n"
                + "rule \"Print text\"\n"
                + "when\n"
                + "$t : Text()\n"
                + "then\n"
                + "System.out.println($t.getText());\n"
                + "end";

        System.out.println(rules);

        // Output first part
		System.out.println("Hello");

		// Get Drools to output second part
		Text t = new Text("String World");

		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newByteArrayResource(rules.getBytes()), ResourceType.DRL);

//		if (kbuilder.hasErrors()) {
//			System.err.println(kbuilder.getErrors().toString());
//		}
//
//        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
//		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
//
//        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
//        ksession.execute(t);
    }

	public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        hw.run();
	}
}