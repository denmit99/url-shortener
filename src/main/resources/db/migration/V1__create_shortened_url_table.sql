CREATE TABLE IF NOT EXISTS shortened_url (
    id SERIAL PRIMARY KEY,
    original_url TEXT NOT NULL,
    code TEXT NOT NULL,
    creation_date timestamptz NOT NULL
);

CREATE INDEX IF NOT EXISTS shortened_url_code_index ON shortened_url USING HASH (code);