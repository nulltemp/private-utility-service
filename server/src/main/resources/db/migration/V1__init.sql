CREATE TABLE public.authors (
	id serial8 NOT NULL,
	"name" varchar NOT NULL,
	insert_date timestamp without time zone NOT NULL DEFAULT now(),
	update_date timestamp without time zone NOT NULL DEFAULT now(),
	CONSTRAINT authors_pk PRIMARY KEY (id)
);

CREATE TABLE public.work_histories (
	id bigserial NOT NULL,
	author_id bigint NOT NULL,
	name varchar NOT NULL,
	insert_date timestamp NOT NULL DEFAULT now(),
	update_date timestamp NOT NULL DEFAULT now(),
	CONSTRAINT work_histories_pk PRIMARY KEY (id),
	CONSTRAINT work_histories_fk FOREIGN KEY (author_id) REFERENCES public.authors(id)
);
