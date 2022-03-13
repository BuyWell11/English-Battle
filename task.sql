--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

-- Started on 2022-03-09 21:52:00

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 213 (class 1259 OID 25497)
-- Name: hds_choose_word; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hds_choose_word (
    skill_id integer NOT NULL,
    skill_task character varying NOT NULL,
    answer_options character varying[] NOT NULL,
    right_answer character varying NOT NULL
);


ALTER TABLE public.hds_choose_word OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 25504)
-- Name: hds_translation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hds_translation (
    skill_id integer NOT NULL,
    skill_task character varying NOT NULL,
    right_answer character varying NOT NULL
);


ALTER TABLE public.hds_translation OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 25472)
-- Name: lds_picture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lds_picture (
    skill_id integer NOT NULL,
    task_picture character varying NOT NULL,
    answer_options character varying[] NOT NULL,
    rigth_answer character varying NOT NULL
);


ALTER TABLE public.lds_picture OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 25465)
-- Name: lds_word; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lds_word (
    skill_id integer NOT NULL,
    skill_task character varying NOT NULL,
    answer_options character varying[] NOT NULL,
    rigth_answer character varying NOT NULL
);


ALTER TABLE public.lds_word OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 25483)
-- Name: mds_make_sentence; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mds_make_sentence (
    skill_id integer NOT NULL,
    skill_task character varying NOT NULL,
    word_list character varying[] NOT NULL,
    right_answer character varying NOT NULL
);


ALTER TABLE public.mds_make_sentence OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 25490)
-- Name: mds_make_word; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mds_make_word (
    skill_id integer NOT NULL,
    skill_task character varying NOT NULL,
    letter_list character varying[] NOT NULL,
    right_answer character varying NOT NULL
);


ALTER TABLE public.mds_make_word OWNER TO postgres;

--
-- TOC entry 3338 (class 0 OID 25497)
-- Dependencies: 213
-- Data for Name: hds_choose_word; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hds_choose_word (skill_id, skill_task, answer_options, right_answer) FROM stdin;
\.


--
-- TOC entry 3339 (class 0 OID 25504)
-- Dependencies: 214
-- Data for Name: hds_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hds_translation (skill_id, skill_task, right_answer) FROM stdin;
\.


--
-- TOC entry 3335 (class 0 OID 25472)
-- Dependencies: 210
-- Data for Name: lds_picture; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lds_picture (skill_id, task_picture, answer_options, rigth_answer) FROM stdin;
\.


--
-- TOC entry 3334 (class 0 OID 25465)
-- Dependencies: 209
-- Data for Name: lds_word; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lds_word (skill_id, skill_task, answer_options, rigth_answer) FROM stdin;
\.


--
-- TOC entry 3336 (class 0 OID 25483)
-- Dependencies: 211
-- Data for Name: mds_make_sentence; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mds_make_sentence (skill_id, skill_task, word_list, right_answer) FROM stdin;
\.


--
-- TOC entry 3337 (class 0 OID 25490)
-- Dependencies: 212
-- Data for Name: mds_make_word; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mds_make_word (skill_id, skill_task, letter_list, right_answer) FROM stdin;
\.


--
-- TOC entry 3192 (class 2606 OID 25503)
-- Name: hds_choose_word hds_choose_word_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hds_choose_word
    ADD CONSTRAINT hds_choose_word_pkey PRIMARY KEY (skill_id);


--
-- TOC entry 3194 (class 2606 OID 25510)
-- Name: hds_translation hds_translation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hds_translation
    ADD CONSTRAINT hds_translation_pkey PRIMARY KEY (skill_id);


--
-- TOC entry 3186 (class 2606 OID 25478)
-- Name: lds_picture lds_picture_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lds_picture
    ADD CONSTRAINT lds_picture_pkey PRIMARY KEY (skill_id);


--
-- TOC entry 3184 (class 2606 OID 25471)
-- Name: lds_word lds_word_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lds_word
    ADD CONSTRAINT lds_word_pkey PRIMARY KEY (skill_id);


--
-- TOC entry 3188 (class 2606 OID 25489)
-- Name: mds_make_sentence mds_make_sentence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mds_make_sentence
    ADD CONSTRAINT mds_make_sentence_pkey PRIMARY KEY (skill_id);


--
-- TOC entry 3190 (class 2606 OID 25496)
-- Name: mds_make_word mds_make_word_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mds_make_word
    ADD CONSTRAINT mds_make_word_pkey PRIMARY KEY (skill_id);


-- Completed on 2022-03-09 21:52:01

--
-- PostgreSQL database dump complete
--

