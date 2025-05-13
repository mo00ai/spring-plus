package org.example.expert.domain.log.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLog is a Querydsl query type for Log
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLog extends EntityPathBase<Log> {

    private static final long serialVersionUID = 2144785399L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLog log = new QLog("log");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isFailed = createBoolean("isFailed");

    public final org.example.expert.domain.manager.entity.QManager manager;

    public final DateTimePath<java.time.LocalDateTime> time = createDateTime("time", java.time.LocalDateTime.class);

    public QLog(String variable) {
        this(Log.class, forVariable(variable), INITS);
    }

    public QLog(Path<? extends Log> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLog(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLog(PathMetadata metadata, PathInits inits) {
        this(Log.class, metadata, inits);
    }

    public QLog(Class<? extends Log> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.manager = inits.isInitialized("manager") ? new org.example.expert.domain.manager.entity.QManager(forProperty("manager"), inits.get("manager")) : null;
    }

}

