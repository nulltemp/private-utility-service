CREATE TABLE public.burn_down_charts (
	id serial8 NOT NULL,
	"name" varchar NOT NULL,
	insert_date timestamp without time zone NOT NULL DEFAULT now(),
	update_date timestamp without time zone NOT NULL DEFAULT now(),
	CONSTRAINT burn_down_charts_pk PRIMARY KEY (id)
);

CREATE TABLE public.burn_down_chart_values (
	id serial8 NOT NULL,
	burn_down_chart_id bigint NOT NULL,
	"date" date NOT NULL,
	value integer NOT NULL,
	insert_date timestamp without time zone NOT NULL DEFAULT now(),
	update_date timestamp without time zone NOT NULL DEFAULT now(),
	CONSTRAINT burn_down_chart_values_pk PRIMARY KEY (id),
	CONSTRAINT burn_down_chart_values_fk FOREIGN KEY (burn_down_chart_id) REFERENCES public.burn_down_charts(id)
);