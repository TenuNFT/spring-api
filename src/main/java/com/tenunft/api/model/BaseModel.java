package com.tenunft.api.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.tenunft.api.helper.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Base Model
 * this is simple standard for spring boot entity class
 *
 * @author kneotrino
 * @version 1.0
 * @since 2021-1-1
 */

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel implements Serializable {

    private static final long serialVersionUID = -260807388675307862L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    protected Long id;

    @Column(columnDefinition = "integer DEFAULT 0", nullable = false)
    protected Integer version = 0;

    @GenericGenerator(name = "uuid", strategy = "uuid4")
    @Column(length = 36, updatable = false, nullable = false)
    protected String uuid;

    @Column(nullable = false)
    protected boolean enabled;

    @Column(updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Date DateCreated;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Date DateModified;

    @Transient
    private StringBuilder debugLogs = new StringBuilder(System.lineSeparator());


    @PrePersist
    protected void onCreated() {
        this.uuid = UUID.randomUUID().toString();
        this.DateCreated = new Date();
        this.enabled = Boolean.TRUE;
    }

    @PreUpdate
    protected void onUpdated() {
        this.DateModified = new Date();
        this.version++;
    }

    @Override
    public String toString() {
        String json = null;
        try {
            json = JsonUtil.toString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    void appendLog(String newLine) {
        this.getDebugLogs()
                .append("[DEBUG] ")
                .append(newLine)
                .append(System.lineSeparator());
    }

    void appendLog(String newLine, long Amount) {
        this.getDebugLogs()
                .append("[DEBUG] ")
                .append(newLine)
                .append(" = ")
                .append(String.format("%,d", Amount))
                .append(System.lineSeparator());
    }

    public void printLog(Logger log, boolean debug) {
        if (debug) {
            log.info(getDebugLogs().toString());
        } else {
            log.info("Console Debug is Disable");
        }
    }

    public <T> T constructDto(Class<T> classType) {
        ModelMapper modelMapper = JsonUtil.GetDefaultModelMapper();
        return modelMapper.map(this, classType);
    }


}
