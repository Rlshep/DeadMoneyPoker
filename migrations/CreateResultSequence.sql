--DROP SEQUENCE result_sequence;

CREATE SEQUENCE result_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE result_sequence
  OWNER TO vtpjadxs;
COMMENT ON SEQUENCE result_sequence
  IS 'Sequence for result id.';