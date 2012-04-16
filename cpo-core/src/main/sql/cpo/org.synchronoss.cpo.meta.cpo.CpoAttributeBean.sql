delete from CPO_QUERY_PARAMETER  where query_id in (select distinct query_id from CPO_QUERY where group_id in (select distinct group_id from CPO_QUERY_GROUP where class_id=(select class_id from CPO_CLASS where name='org.synchronoss.cpo.meta.cpo.CpoAttributeBean')));
delete from CPO_QUERY where group_id in (select distinct group_id from CPO_QUERY_GROUP where class_id=(select class_id from CPO_CLASS where name='org.synchronoss.cpo.meta.cpo.CpoAttributeBean'));
delete from cpo_query_text where text_id = '0cbb9e0e-0a0e-1e64-0c4c-7e106fe6d701';
delete from cpo_query_text where text_id = '0d2e3b1f-0a0e-1e64-0c4c-7e102a5827a8';
delete from cpo_query_text where text_id = '0cbb7822-0a0e-1e64-0c4c-7e1033536fc5';
delete from cpo_query_text where text_id = '0cbbfab7-0a0e-1e64-0c4c-7e103c04ce09';
delete from cpo_query_text where text_id = '0cc523d7-0a0e-1e64-0c4c-7e10f3d3c3df';
delete from cpo_query_text where text_id = '0cbbcd3b-0a0e-1e64-0c4c-7e1050fa164a';
delete from CPO_QUERY_GROUP where class_id=(select class_id from CPO_CLASS where name='org.synchronoss.cpo.meta.cpo.CpoAttributeBean');
delete from CPO_ATTRIBUTE_MAP where class_id=(select class_id from CPO_CLASS where name='org.synchronoss.cpo.meta.cpo.CpoAttributeBean');
delete from CPO_CLASS where name='org.synchronoss.cpo.meta.cpo.CpoAttributeBean';
insert into cpo_query_text (text_id, sql_text, description, userid) values ('0cbb9e0e-0a0e-1e64-0c4c-7e106fe6d701','delete from __CPO_TABLE_PREFIX__cpo_attribute_map where attribute_id = ?','CpoAttributeBean - deleteAttribute','dberry');
insert into cpo_query_text (text_id, sql_text, description, userid) values ('0d2e3b1f-0a0e-1e64-0c4c-7e102a5827a8','delete from __CPO_TABLE_PREFIX__cpo_attribute_map where class_id = ?','CpoAttributeBean - deleteAttributesForClass','dberry');
insert into cpo_query_text (text_id, sql_text, description, userid) values ('0cbb7822-0a0e-1e64-0c4c-7e1033536fc5','insert into __CPO_TABLE_PREFIX__cpo_attribute_map (ATTRIBUTE, ATTRIBUTE_ID, CLASS_ID, COLUMN_NAME, COLUMN_TYPE, CREATEDATE, DB_COLUMN, DB_TABLE, TRANSFORM_CLASS, USERID) values (?,?,?,?,?,?,?,?,?,?)','CpoAttributeBean - insertAttribute','dberry');
insert into cpo_query_text (text_id, sql_text, description, userid) values ('0cbbfab7-0a0e-1e64-0c4c-7e103c04ce09','select * from __CPO_TABLE_PREFIX__cpo_attribute_map where attribute_id = ?','CpoAttributeBean - retrieveAttribute','dberry');
insert into cpo_query_text (text_id, sql_text, description, userid) values ('0cc523d7-0a0e-1e64-0c4c-7e10f3d3c3df','select * from __CPO_TABLE_PREFIX__cpo_attribute_map where class_id = ? order by attribute','CpoAttributeBean - retrieveAttributesForClass','dberry');
insert into cpo_query_text (text_id, sql_text, description, userid) values ('0cbbcd3b-0a0e-1e64-0c4c-7e1050fa164a','update __CPO_TABLE_PREFIX__cpo_attribute_map set ATTRIBUTE = ?, COLUMN_NAME = ?, COLUMN_TYPE = ?, DB_COLUMN = ?, DB_TABLE = ?, TRANSFORM_CLASS = ? where ATTRIBUTE_ID=?','CpoAttributeBean - updateAttribute','dberry');
insert into cpo_class (class_id, name, userid) values ('0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','org.synchronoss.cpo.meta.cpo.CpoAttributeBean','dberry');
insert into cpo_attribute_map (attribute_id, class_id, column_name, attribute, column_type, db_column, db_table,transform_class, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e1086c15cf4','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','ATTRIBUTE','attribute','VARCHAR',null,null,null,'dberry');
insert into cpo_attribute_map (attribute_id, class_id, column_name, attribute, column_type, db_column, db_table,transform_class, userid) values ('0c995ed8-0a0e-1e64-0c4c-7e109dd52107','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','ATTRIBUTE_ID','attributeId','VARCHAR',null,null,null,'dberry');
insert into cpo_attribute_map (attribute_id, class_id, column_name, attribute, column_type, db_column, db_table,transform_class, userid) values ('0c995ed8-0a0e-1e64-0c4c-7e105fe000bc','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','CLASS_ID','classId','VARCHAR',null,null,null,'dberry');
insert into cpo_attribute_map (attribute_id, class_id, column_name, attribute, column_type, db_column, db_table,transform_class, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e10c5e99d37','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','COLUMN_NAME','columnName','VARCHAR',null,null,null,'dberry');
insert into cpo_attribute_map (attribute_id, class_id, column_name, attribute, column_type, db_column, db_table,transform_class, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e10c184ac35','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','COLUMN_TYPE','columnType','VARCHAR',null,null,null,'dberry');
insert into cpo_attribute_map (attribute_id, class_id, column_name, attribute, column_type, db_column, db_table,transform_class, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e10d0774c62','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','CREATEDATE','createdate','DATE',null,null,'org.synchronoss.cpo.transform.jdbc.TransformTimestampToCalendar','dberry');
insert into cpo_attribute_map (attribute_id, class_id, column_name, attribute, column_type, db_column, db_table,transform_class, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e107b79c2f9','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','DB_COLUMN','dbColumn','VARCHAR',null,null,null,'dberry');
insert into cpo_attribute_map (attribute_id, class_id, column_name, attribute, column_type, db_column, db_table,transform_class, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e100e0731da','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','DB_TABLE','dbTable','VARCHAR',null,null,null,'dberry');
insert into cpo_attribute_map (attribute_id, class_id, column_name, attribute, column_type, db_column, db_table,transform_class, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e1072380505','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','TRANSFORM_CLASS','transformClass','VARCHAR',null,null,null,'dberry');
insert into cpo_attribute_map (attribute_id, class_id, column_name, attribute, column_type, db_column, db_table,transform_class, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e10dd87b097','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','USERID','userid','VARCHAR',null,null,null,'dberry');
insert into cpo_query_group (group_id, class_id, group_type, name, userid) values ('0cc04c12-0a0e-1e64-0c4c-7e101d99385b','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','DELETE','deleteAttribute','dberry');
insert into cpo_query (query_id, group_id, text_id, seq_no, userid) values ('0cc04c13-0a0e-1e64-0c4c-7e10ffb4ec31','0cc04c12-0a0e-1e64-0c4c-7e101d99385b','0cbb9e0e-0a0e-1e64-0c4c-7e106fe6d701','0','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed8-0a0e-1e64-0c4c-7e109dd52107','0cc04c13-0a0e-1e64-0c4c-7e10ffb4ec31','1','IN','dberry');
insert into cpo_query_group (group_id, class_id, group_type, name, userid) values ('0d2eab42-0a0e-1e64-0c4c-7e1042ae2099','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','DELETE','deleteAttributesForClass','dberry');
insert into cpo_query (query_id, group_id, text_id, seq_no, userid) values ('0d2eab43-0a0e-1e64-0c4c-7e10ed4acecc','0d2eab42-0a0e-1e64-0c4c-7e1042ae2099','0d2e3b1f-0a0e-1e64-0c4c-7e102a5827a8','0','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed8-0a0e-1e64-0c4c-7e105fe000bc','0d2eab43-0a0e-1e64-0c4c-7e10ed4acecc','1','IN','dberry');
insert into cpo_query_group (group_id, class_id, group_type, name, userid) values ('0cbdab0c-0a0e-1e64-0c4c-7e104692a69f','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','CREATE','insertAttribute','dberry');
insert into cpo_query (query_id, group_id, text_id, seq_no, userid) values ('0cbdab0d-0a0e-1e64-0c4c-7e10a113520d','0cbdab0c-0a0e-1e64-0c4c-7e104692a69f','0cbb7822-0a0e-1e64-0c4c-7e1033536fc5','0','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e1086c15cf4','0cbdab0d-0a0e-1e64-0c4c-7e10a113520d','1','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed8-0a0e-1e64-0c4c-7e109dd52107','0cbdab0d-0a0e-1e64-0c4c-7e10a113520d','2','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed8-0a0e-1e64-0c4c-7e105fe000bc','0cbdab0d-0a0e-1e64-0c4c-7e10a113520d','3','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e10c5e99d37','0cbdab0d-0a0e-1e64-0c4c-7e10a113520d','4','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e10c184ac35','0cbdab0d-0a0e-1e64-0c4c-7e10a113520d','5','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e10d0774c62','0cbdab0d-0a0e-1e64-0c4c-7e10a113520d','6','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e107b79c2f9','0cbdab0d-0a0e-1e64-0c4c-7e10a113520d','7','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e100e0731da','0cbdab0d-0a0e-1e64-0c4c-7e10a113520d','8','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e1072380505','0cbdab0d-0a0e-1e64-0c4c-7e10a113520d','9','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e10dd87b097','0cbdab0d-0a0e-1e64-0c4c-7e10a113520d','10','IN','dberry');
insert into cpo_query_group (group_id, class_id, group_type, name, userid) values ('0cc3716e-0a0e-1e64-0c4c-7e1033c69d28','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','RETRIEVE','retrieveAttribute','dberry');
insert into cpo_query (query_id, group_id, text_id, seq_no, userid) values ('0cc37170-0a0e-1e64-0c4c-7e101abb442c','0cc3716e-0a0e-1e64-0c4c-7e1033c69d28','0cbbfab7-0a0e-1e64-0c4c-7e103c04ce09','0','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e1086c15cf4','0cc37170-0a0e-1e64-0c4c-7e101abb442c','1','IN','dberry');
insert into cpo_query_group (group_id, class_id, group_type, name, userid) values ('0d2d44f4-0a0e-1e64-0c4c-7e109e695d4d','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','LIST','retrieveAttributesForClass','dberry');
insert into cpo_query (query_id, group_id, text_id, seq_no, userid) values ('0d2d44f5-0a0e-1e64-0c4c-7e1049607840','0d2d44f4-0a0e-1e64-0c4c-7e109e695d4d','0cc523d7-0a0e-1e64-0c4c-7e10f3d3c3df','0','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed8-0a0e-1e64-0c4c-7e105fe000bc','0d2d44f5-0a0e-1e64-0c4c-7e1049607840','1','IN','dberry');
insert into cpo_query_group (group_id, class_id, group_type, name, userid) values ('0cc19883-0a0e-1e64-0c4c-7e10bf7b9a01','0c995ed7-0a0e-1e64-0c4c-7e10b795aaf9','UPDATE','updateAttribute','dberry');
insert into cpo_query (query_id, group_id, text_id, seq_no, userid) values ('0cc19884-0a0e-1e64-0c4c-7e10c0cb9dce','0cc19883-0a0e-1e64-0c4c-7e10bf7b9a01','0cbbcd3b-0a0e-1e64-0c4c-7e1050fa164a','0','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e1086c15cf4','0cc19884-0a0e-1e64-0c4c-7e10c0cb9dce','1','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e10c5e99d37','0cc19884-0a0e-1e64-0c4c-7e10c0cb9dce','2','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e10c184ac35','0cc19884-0a0e-1e64-0c4c-7e10c0cb9dce','3','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e107b79c2f9','0cc19884-0a0e-1e64-0c4c-7e10c0cb9dce','4','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e100e0731da','0cc19884-0a0e-1e64-0c4c-7e10c0cb9dce','5','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed9-0a0e-1e64-0c4c-7e1072380505','0cc19884-0a0e-1e64-0c4c-7e10c0cb9dce','6','IN','dberry');
insert into cpo_query_parameter (attribute_id, query_id, seq_no, param_type, userid) values ('0c995ed8-0a0e-1e64-0c4c-7e109dd52107','0cc19884-0a0e-1e64-0c4c-7e10c0cb9dce','7','IN','dberry');