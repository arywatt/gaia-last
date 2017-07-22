/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.module.entities;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author komilo
 */
@Entity
@DiscriminatorValue("M")
public class Module extends Plugin {
    
    private boolean fixed;

    @ManyToMany(mappedBy = "dependencies")
    private List<Module> requirements = new LinkedList<Module>();;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="core_module_dependencies",
        joinColumns={@JoinColumn(name="dependency_id", nullable=false)},
        inverseJoinColumns={@JoinColumn(name="requirement_id", nullable=false)}
    )
    private List<Module> dependencies = new LinkedList<Module>();
    
    @Column(name="dependencies_text", nullable=false)
    private String dependenciesText = "";
    
    @Column(name="requirements_text", nullable=false)
    private String requirementsText = "";

    public Module() {
    }

    public Module(String name) {
        super(name);
    }

    public Module(String name, String nameKey, String descriptionKey, String pluginVersion,
            boolean fixed) {
        super(name, nameKey, descriptionKey, pluginVersion);
        this.fixed = fixed;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public List<Module> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Module> dependencies) {
        this.dependencies = dependencies;
    }

    public List<Module> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Module> requirements) {
        this.requirements = requirements;
    }

    public void setDependenciesText(String dependenciesText) {
        this.dependenciesText = dependenciesText;
    }
    
    public String getDependenciesText() {
        return this.dependenciesText;
    }

    public String getRequirementsText() {
        return requirementsText;
    }

    public void setRequirementsText(String requirementsText) {
        this.requirementsText = requirementsText;
    }
    
    @PrePersist
    @PreUpdate
    private void computeTexts() {
        StringBuilder builder = new StringBuilder();
        int i = 1;
        for (Module module : this.dependencies) {
            System.out.println("++++++++++++ Module : " +getName()+"-->"+ module);
            builder.append(module.getDisplayName());
            if (i < this.dependencies.size()) {
                builder.append(", ");
            } else {
                builder.append(".");
            }
            i++;
        }
        this.dependenciesText = builder.toString();
        
        builder = new StringBuilder();
        for (Module module : this.requirements) {
            builder.append(module.getDisplayName());
            if (i < this.requirements.size()) {
                builder.append(", ");
            } else {
                builder.append(".");
            }
            i++;
        }
        this.requirementsText = builder.toString();
    }
}
