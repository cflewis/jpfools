package com.cflewis.jpfools.listener;

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

public class Mayet extends ListenerAdapter {
    StatelessKnowledgeSession ksession;

    public Mayet(Config conf, JPF jpf) {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("print.drl"), ResourceType.DRL);

        if (kbuilder.hasErrors()) {
            System.err.println(kbuilder.getErrors().toString());
        }

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

        ksession = kbase.newStatelessKnowledgeSession();
    }
    
    @Override
    public void methodEntered(JVM jvm) {
        MethodInfo mi = jvm.getLastMethodInfo();
        
        if (mi.getFullName().startsWith("com.cflewis.jpfools")) {
            ksession.execute(mi.getFullName());
        }
    }
}
