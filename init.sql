BEGIN;


CREATE TABLE IF NOT EXISTS public.tasks (
  id BIGSERIAL PRIMARY KEY,
  caption text,
  content text,
  completed boolean,
  created_at timestamp without time zone DEFAULT current_timestamp NOT NULL,
  deleted_at timestamp without time zone,
  updated_at timestamp without time zone DEFAULT current_timestamp NOT NULL
);

COMMIT;