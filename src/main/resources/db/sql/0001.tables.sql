CREATE TABLE "user" (
    user_id uuid PRIMARY KEY,
    last_name VARCHAR(255),
    first_name VARCHAR(255),
    telegram VARCHAR(255),
    role VARCHAR(255),
    area VARCHAR(255),
    competence VARCHAR(50) CHECK (meeting_type IN ('Начальный (Junior)', 'Средний (Middle)', 'Продвинутый (Senior)', 'Эксперт (Lead/Principal)', 'Руководитель (Manager)'))
);

CREATE TABLE slot (
    slot_id uuid primary key,
    user_id uuid,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    description VARCHAR(255),
    type_slot VARCHAR(20),
    gi BOOLEAN,
    CONSTRAINT fk_user foreign key (user_id) references "user"(user_id) on delete set null on update cascade
);

CREATE TABLE meeting (
    meeting_id uuid PRIMARY KEY,
    slot_id uuid,
    expert_id uuid,
    client_id uuid,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    meeting_type VARCHAR(20),
    CONSTRAINT fk_slot foreign key (slot_id) references slot(slot_id) on delete set null on update cascade,
    CONSTRAINT fk_user_expert foreign key (expert_id) references "user"(user_id) on delete set null on update cascade,
    CONSTRAINT fk_user_client foreign key (client_id) references "user"(user_id) on delete set null on update cascade
);

CREATE TABLE change (
    comment_id uuid PRIMARY KEY,
    meeting_id uuid,
    user_id uuid,
    meeting_status VARCHAR(20),
    description VARCHAR(255),
    change_time TIMESTAMP,
    CONSTRAINT fk_meeting foreign key (meeting_id) references meeting(meeting_id) on delete cascade on update cascade,
    CONSTRAINT fk_user foreign key (user_id) references "user"(user_id) on delete cascade on update cascade
);