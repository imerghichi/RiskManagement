DROP SCHEMA IF EXISTS mydb ;

CREATE SCHEMA IF NOT EXISTS mydb;
USE mydb ;

DROP TABLE IF EXISTS mydb.Portfolio ;

CREATE TABLE IF NOT EXISTS mydb.Portfolio (
  id_portfolio INT NOT NULL,
  description VARCHAR(45) NULL,
  mean DOUBLE NULL,
  standardDeviation DOUBLE NULL DEFAULT CURRENT_TIMESTAMP,
  inflationRate DECIMAL NULL,
  initialInvestment VARCHAR(45) NULL,
  PRIMARY KEY (id_portfolio));


DROP TABLE IF EXISTS mydb.Project ;

CREATE TABLE IF NOT EXISTS mydb.Project (
  id_project INT NOT NULL,
  project_name VARCHAR(45) ,
  project_description VARCHAR(45) NULL,
  Portfolio_id_portfolio INT NOT NULL,
  PRIMARY KEY (id_project),
  CONSTRAINT fk_Project_Portfolio1
    FOREIGN KEY (Portfolio_id_portfolio)
    REFERENCES mydb.Portfolio (id_portfolio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX fk_Project_Portfolio1_idx ON mydb.Project (Portfolio_id_portfolio ASC);



DROP TABLE IF EXISTS mydb.Activity ;

CREATE TABLE IF NOT EXISTS mydb.Activity (
  id_task_project INT NOT NULL,
  task_name VARCHAR(45) NULL,
  description VARCHAR(50) NULL,
  parametre1 INT NULL,
  parametre2 INT NULL,
  parametre3 INT NULL,
  distribution ENUM('Uniform', 'Triangular', 'Gaussian', 'Exponential', 'Beta', 'Gamma', 'Chi_square', 'Log_normal', 'Student', 'Laplace', 'Gumbel') NULL,
  Project_id_project INT NOT NULL,
  Project_id_project1 INT NOT NULL,
  PRIMARY KEY (id_task_project, Project_id_project),
  CONSTRAINT fk_Activity_Project1
    FOREIGN KEY (Project_id_project1)
    REFERENCES mydb.Project (id_project)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX fk_Activity_Project1_idx ON mydb.Activity (Project_id_project1 ASC);



DROP TABLE IF EXISTS mydb.predecesors ;

CREATE TABLE IF NOT EXISTS mydb.predecesors (
  Activity_id_task_project INT NOT NULL,
  Activity_id_task_project1 INT NOT NULL,
  PRIMARY KEY (Activity_id_task_project, Activity_id_task_project1),
  CONSTRAINT fk_Activity_has_Activity_Activity
    FOREIGN KEY (Activity_id_task_project)
    REFERENCES mydb.Activity (id_task_project)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Activity_has_Activity_Activity1
    FOREIGN KEY (Activity_id_task_project1)
    REFERENCES mydb.Activity (id_task_project)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX fk_Activity_has_Activity_Activity1_idx ON mydb.predecesors (Activity_id_task_project1 ASC);

CREATE INDEX fk_Activity_has_Activity_Activity_idx ON mydb.predecesors (Activity_id_task_project ASC);



DROP TABLE IF EXISTS mydb.TeamMember ;

CREATE TABLE IF NOT EXISTS mydb.TeamMember (
  id_team_member INT NOT NULL,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_team_member));



DROP TABLE IF EXISTS mydb.Response ;

CREATE TABLE IF NOT EXISTS mydb.Response (
  id_response INT NOT NULL,
  active TINYINT(1) NULL,
  complete TINYINT(1) NOT NULL,
  response_name VARCHAR(45) NULL DEFAULT CURRENT_TIMESTAMP,
  nonPlanResponseEnum ENUM('avoid', 'transfer', 'acceptance', 'monitoring') NULL,
  PRIMARY KEY (id_response));



DROP TABLE IF EXISTS mydb.Event ;

CREATE TABLE IF NOT EXISTS mydb.Event (
  id_event INT NOT NULL,
  name_event VARCHAR(45) NULL,
  description_event VARCHAR(50) NULL,
  PRIMARY KEY (id_event));



DROP TABLE IF EXISTS mydb.Risk ;

CREATE TABLE IF NOT EXISTS mydb.Risk (
  id_risk INT NOT NULL,
  risk_name VARCHAR(45) NOT NULL,
  description VARCHAR(50) NULL,
  probability FLOAT NULL DEFAULT CURRENT_TIMESTAMP,
  detection_difficulty FLOAT NULL,
  vulnerability FLOAT NULL,
  impact ENUM('ACCEPTABLE', 'TOLERABLE', 'UNACCEPTABLE', 'INTOLERABLE') NULL,
  active TINYINT(1) NULL,
  consequence_desription VARCHAR(45) NULL,
  date_risk DATE NULL,
  nature_risk ENUM('hazard', 'constraint', 'nominal', 'trivial') NULL,
  origin_risk ENUM('external', 'internal', 'vendor') NULL,
  type_risk ENUM('strategic_risk', 'compliance_and_regulatory_risk', 'financial_risk', 'operational_risk') NULL,
  category ENUM('f') NULL,
  owner_level ENUM('Enterprise_Level', 'SBU_Level', 'Program_Level', 'Project_Level', 'process_level') NULL,
  visibility ENUM('very_low', 'low', 'normal', 'high', 'very_high') NULL,
  detected TINYINT(1) NULL,
  taxonomy ENUM('Requirement', 'Design', 'Code_and_unit_test', 'Integration_and_test', 'Engineering_specialities', 'Development_process', 'Development_system', 'Management_process', 'Management_methods', 'Work_environment', 'Resources', 'Contract', 'Program_interface') NULL,
  Activity_id_task_project INT NOT NULL,
  Activity_Project_id_project INT NOT NULL,
  TeamMember_id_team_member INT NOT NULL,
  Response_id_response INT NOT NULL,
  Event_id_event INT NOT NULL,
  PRIMARY KEY (id_risk),
  CONSTRAINT fk_Risk_Activity1
    FOREIGN KEY (Activity_id_task_project , Activity_Project_id_project)
    REFERENCES mydb.Activity (id_task_project , Project_id_project)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Risk_TeamMember1
    FOREIGN KEY (TeamMember_id_team_member)
    REFERENCES mydb.TeamMember (id_team_member)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Risk_Response1
    FOREIGN KEY (Response_id_response)
    REFERENCES mydb.Response (id_response)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Risk_Event1
    FOREIGN KEY (Event_id_event)
    REFERENCES mydb.Event (id_event)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX fk_Risk_Activity1_idx ON mydb.Risk (Activity_id_task_project ASC, Activity_Project_id_project ASC);

CREATE INDEX fk_Risk_TeamMember1_idx ON mydb.Risk (TeamMember_id_team_member ASC);

CREATE INDEX fk_Risk_Response1_idx ON mydb.Risk (Response_id_response ASC);

CREATE INDEX fk_Risk_Event1_idx ON mydb.Risk (Event_id_event ASC);


DROP TABLE IF EXISTS mydb.Task ;

CREATE TABLE IF NOT EXISTS mydb.Task (
  id_task INT NOT NULL,
  task VARCHAR(45) NULL,
  done TINYINT(1) NULL,
  planned_start_day DATE NULL DEFAULT CURRENT_TIMESTAMP,
  actual_start_day DATE NULL,
  planned_completion_day DATE NULL,
  actual_completion_day DATE NULL,
  level INT NULL,
  condition VARCHAR(45) NULL,
  due_date DATE NULL,
  Response_id_response INT NOT NULL,
  PRIMARY KEY (id_task, Response_id_response),
  CONSTRAINT fk_Task_Response1
    FOREIGN KEY (Response_id_response)
    REFERENCES mydb.Response (id_response)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX fk_Task_Response1_idx ON mydb.Task (Response_id_response ASC);


DROP TABLE IF EXISTS mydb.LeafEvent ;

CREATE TABLE IF NOT EXISTS mydb.LeafEvent (
  id_leafEvent INT NOT NULL,
  event_name VARCHAR(45) NULL,
  type ENUM('base_event', 'home_event', 'non_developped_event') NULL,
  probability FLOAT NULL DEFAULT CURRENT_TIMESTAMP,
  operande ENUM('OR', 'AND') NULL,
  Risk_id_risk INT NOT NULL,
  LeafEvent_id_leafEvent INT NOT NULL,
  LeafEvent_id_leafEvent1 INT NOT NULL,
  PRIMARY KEY (id_leafEvent),
  CONSTRAINT fk_LeafEvent_Risk1
    FOREIGN KEY (Risk_id_risk)
    REFERENCES mydb.Risk (id_risk)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_LeafEvent_LeafEvent1
    FOREIGN KEY (LeafEvent_id_leafEvent)
    REFERENCES mydb.LeafEvent (id_leafEvent)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_LeafEvent_LeafEvent2
    FOREIGN KEY (LeafEvent_id_leafEvent1)
    REFERENCES mydb.LeafEvent (id_leafEvent)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX fk_LeafEvent_Risk1_idx ON mydb.LeafEvent (Risk_id_risk ASC);

CREATE INDEX fk_LeafEvent_LeafEvent1_idx ON mydb.LeafEvent (LeafEvent_id_leafEvent ASC);

CREATE INDEX fk_LeafEvent_LeafEvent2_idx ON mydb.LeafEvent (LeafEvent_id_leafEvent1 ASC);



DROP TABLE IF EXISTS mydb.workson ;

CREATE TABLE IF NOT EXISTS mydb.workson (
  Project_id_project INT NOT NULL,
  TeamMember_id_team_member INT NOT NULL,
  PRIMARY KEY (Project_id_project, TeamMember_id_team_member),
  CONSTRAINT fk_Project_has_TeamMember_Project1
    FOREIGN KEY (Project_id_project)
    REFERENCES mydb.Project (id_project)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Project_has_TeamMember_TeamMember1
    FOREIGN KEY (TeamMember_id_team_member)
    REFERENCES mydb.TeamMember (id_team_member)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX fk_Project_has_TeamMember_TeamMember1_idx ON mydb.workson (TeamMember_id_team_member ASC);

CREATE INDEX fk_Project_has_TeamMember_Project1_idx ON mydb.workson (Project_id_project ASC);



--SET SQL_MODE=@OLD_SQL_MODE;
--SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
--SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;