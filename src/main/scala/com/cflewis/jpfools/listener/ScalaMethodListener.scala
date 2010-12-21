package com.cflewis.jpfools.listener

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;


import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.jvm.JVM;
import gov.nasa.jpf.jvm.MethodInfo;

class ScalaMethodListener extends ListenerAdapter {
    private val kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder
    kbuilder.add(ResourceFactory.newClassPathResource("print.drl"), ResourceType.DRL)

    if (kbuilder.hasErrors) {
        System.err.println(kbuilder.getErrors.toString)
    }

    private val kbase = KnowledgeBaseFactory.newKnowledgeBase
    kbase.addKnowledgePackages(kbuilder.getKnowledgePackages)

    private val ksession = kbase.newStatelessKnowledgeSession

    override def methodEntered(jvm: JVM) = {
        val mi = jvm.getLastMethodInfo
        
        if (mi.getFullName.startsWith("com.cflewis")) {
            ksession.execute(mi.getFullName)
        }
    }
}