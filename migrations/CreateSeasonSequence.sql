--DROP SEQUENCE season_sequence;

CREATE SEQUENCE season_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE season_sequence
  OWNER TO vtpjadxs;
COMMENT ON SEQUENCE season_sequence
  IS 'Sequence for season id.';