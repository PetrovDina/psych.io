package com.sbnz.psychio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sbnz.psychio.model.enums.Response;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disorder_group_id")
    private DisorderGroup disorderGroup;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "diagnosis")
    private List<Statement> statements;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "diagnosis_substance", joinColumns = @JoinColumn(name = "diagnosis_id"), inverseJoinColumns = @JoinColumn(name = "substance_group_id"))
    private List<SubstanceGroup> substances;

    public double getMaxScore() {
        int maxScore = 0;
        for (Statement statement : statements) {
            maxScore += statement.getOccurence() * Response.getResponseValue(Response.STRONGLY_AGREE);
        }
        return maxScore;
    }

    public double getMinimumScore() {
        return 0.1 * this.getMaxScore(); // 10% of max score
    }

    public boolean isStatementOccurent(Statement s) {

        // TODO check if logic is ok
        for (Statement statement : statements) {
            if (statement.getId().equals(s.getId())) {
                return true;
            }
        }
        return false;
    }

    public int getStatementOccurence(Statement s) {
        for (Statement statement : statements) {
            if (statement.getId().equals(s.getId())) {
                return statement.getOccurence();
            }
        }
        return 0;
    }

    public boolean isSubstanceOccurent(SubstanceGroup substance) {
        for (SubstanceGroup sg : substances) {
            if (sg.getId().equals(substance.getId())) {
                return true;
            }
        }
        return false;
    }

}
