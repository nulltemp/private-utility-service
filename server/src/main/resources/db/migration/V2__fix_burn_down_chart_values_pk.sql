ALTER TABLE public.burn_down_chart_values DROP CONSTRAINT burn_down_chart_values_pk;
ALTER TABLE public.burn_down_chart_values DROP COLUMN id;
ALTER TABLE public.burn_down_chart_values ADD CONSTRAINT burn_down_chart_values_pk PRIMARY KEY (burn_down_chart_id,"date");