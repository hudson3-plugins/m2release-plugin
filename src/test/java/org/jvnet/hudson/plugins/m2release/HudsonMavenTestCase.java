/**
 * *****************************************************************************
 *
 * Copyright (c) 2012 Oracle Corporation.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *   Winston Prakash
 *
 ******************************************************************************
 */
package org.jvnet.hudson.plugins.m2release;

import hudson.maven.MavenBuild;
import hudson.maven.MavenModule;
import hudson.maven.MavenModuleSet;
import hudson.maven.MavenModuleSetBuild;
import java.io.IOException;
import org.jvnet.hudson.test.HudsonTestCase;

public class HudsonMavenTestCase extends HudsonTestCase {

    /**
     * Creates a empty Maven project with an unique name.
     *     
     * @see #configureDefaultMaven()
     */
    protected MavenModuleSet createMavenProject() throws IOException {
        return createMavenProject(createUniqueProjectName());
    }

    /**
     * Creates a empty Maven project with the given name.
     *     
     * @see #configureDefaultMaven()
     */
    protected MavenModuleSet createMavenProject(String name) throws IOException {
        return hudson.createProject(MavenModuleSet.class, name);
    }
    
    public MavenModuleSetBuild buildAndAssertSuccess(MavenModuleSet job) throws Exception {
       return assertBuildStatusSuccess(job.scheduleBuild2(0));
    }
    public MavenBuild buildAndAssertSuccess(MavenModule job) throws Exception {
        return assertBuildStatusSuccess(job.scheduleBuild2(0));
    }
}
