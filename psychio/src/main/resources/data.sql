INSERT INTO DISORDER_GROUP (ID, NAME) VALUES
  (1, 'MOOD_DISORDERS'),
  (2, 'ANXIETY_DISORDERS'),
  (3, 'EATING_DISORDERS'),
  (4, 'PSYCHOTIC_DISORDERS'),
  (5, 'PERSONALITY_DISORDERS');


INSERT INTO SYMPTOM (ID, DESCRIPTION) VALUES
  (1, 'Feeling sad or down'),
  (2, 'Suicidal behaviour'),
  (3, 'Excessive anger, hostility or violence'),
  (4, 'Crying easily'),
  (5, 'Self harm'),
  (6, 'Feelings of worthlessness'),
  (7, 'Excessive fears/worries'),
  (8, 'Social withdrawal'),
  (9, 'Inability to cope with daily problems and stress'),
  (10, 'Spells of terror or panic'),
  (11, 'Trembling'),
  (12, 'Nervousness or shakiness'),
  (13, 'Fear for no apparent reason'),
  (14, 'Nightmares'),
  (15, 'Intrusive thoughts'),
  (16, 'Racing thoughts'),
  (17, 'Vivid flashbacks, reliving events'),
  (18, 'Avoidance of people, places or things '),
  (19, 'Increased heart rate'),
  (20, 'Eating habits changes'),
  (21, 'Weight changes'),
  (22, 'Anxiety around food and gaining weight'),
  (23, 'Excessive calorie monitoring'),
  (24, 'Negative body image'),
  (25, 'Throwing up'),
  (26, 'Delusions, paranoia'),
  (27, 'Hallucinations'),
  (28, 'Hearing voices'),
  (29, 'Lack of interest, indifference'),
  (30, 'Feeling empty '),
  (31, 'Disorganised speech'),
  (32, 'Extreme mood changes/swings, from mania to depression'),
  (33, 'Abandonment issues'),
  (34, 'Distrust and suspicion of others and their motives'),
  (35, 'Impulsivity in self-damaging acts (unsafe sex, gambling, reckless driving...)'),
  (36, 'Misinterpreting innocent remarks as negative'),
  (37, 'Persistent lying, stealing, using aliases, conning others'),
  (38, 'Unstable relationships'),
  (39, 'Preoccupation with details, rules, schedules, lists, organizaton'),
  (40, 'Obsessive rituals (hand washing, checking the lock, counting ...)'),
  (41, 'Intense perfectionism'),
  (42, 'Hoarding, difficulty getting rid of things'),
  (43, 'Tiredness, low energy'),
  (44, 'Changes in/ lack of sex drive'),
  (45, 'Excessive working out'),
  (46, 'Change in sleeping habits'),
  (47, 'Headaches'),
  (48, 'Concentration difficulties'),
  (49, 'Talkative'),
  (50, 'Lack of empathy and emotional range');


INSERT INTO DISORDER_GROUP_SYMPTOM_OCCURENCE (DISORDER_GROUP_ID, SYMPTOM_ID, OCCURENCE) VALUES
   /* MOOD DISORDERS - 3 */
  (1, 1, 3),
  (1, 2, 3),
  (1, 3, 3),
  (1, 4, 3),
  (1, 5, 3),
  (1, 6, 3),
  /* MOOD DISORDERS - 2 */
  (1, 8, 2),
  (1, 9, 2),
  (1, 20, 2),
  (1, 30, 2),
  (1, 32, 2),
  (1, 44, 2),
  (1, 46, 2),
  (1, 48, 2),
  (1, 49, 2),
  /* MOOD DISORDERS - 1 */
  (1, 7, 1),
  (1, 14, 1),
  (1, 15, 1),
  (1, 16, 1),
  (1, 21, 1),
  (1, 43, 1),
  (1, 47, 1),
  
   /* ANXIETY DISORDERS - 3 */
  (2, 7, 3),
  (2, 8, 3),
  (2, 9, 3),
  (2, 10, 3),
  (2, 11, 3),
  (2, 12, 3),
  (2, 13, 3),
  (2, 14, 3),
  (2, 15, 3),
  (2, 16, 3),
  (2, 17, 3),
  (2, 18, 3),
  (2, 19, 3),
  /* ANXIETY DISORDERS - 2 */
  (2, 46, 2),
  (2, 48, 2),
  /* ANXIETY DISORDERS - 1 */
  (2, 1, 1),
  (2, 4, 1),
  (2, 20, 1),
  (2, 21, 1),
  (2, 32, 1),
  (2, 34, 1),
  (2, 43, 1),
  (2, 44, 1),
  (2, 47, 1),
  
   /* EATING DISORDERS - 3 */
  (3, 20, 3),
  (3, 21, 3),
  (3, 22, 3),
  (3, 23, 3),
  (3, 24, 3),
  (3, 25, 3),
  /* EATING DISORDERS - 2 */
  (3, 8, 2),
  (3, 45, 2),
  /* EATING DISORDERS - 1 */
  (3, 1, 1),
  (3, 2, 1),
  
   /* PSYCHOTIC DISORDERS - 3 */
  (4, 8, 3),
  (4, 15, 3),
  (4, 26, 3),
  (4, 27, 3),
  (4, 28, 3),
  (4, 29, 3),
  (4, 30, 3),
  (4, 31, 3),
  /* PSYCHOTIC DISORDERS - 2 */
  (4, 16, 2),
  (4, 34, 2),
  (4, 38, 2),
  (4, 50, 2),
  /* PSYCHOTIC DISORDERS - 1 */
  (4, 20, 1),
  (4, 48, 1),
  
  /* PERSONALITY DISORDERS - 3 */
  (5, 3, 3),
  (5, 30, 3),
  (5, 32, 3),
  (5, 33, 3),
  (5, 34, 3),
  (5, 35, 3),
  (5, 36, 3),
  (5, 37, 3),
  (5, 38, 3),
  (5, 39, 3),
  (5, 40, 3),
  (5, 41, 3),
  (5, 42, 3),
  /* PERSONALITY DISORDERS - 2 */
  (5, 5, 2),
  (5, 44, 2),
  (5, 50, 2),
  /* PERSONALITY DISORDERS - 1 */
  (5, 15, 1),
  (5, 49, 1);  


INSERT INTO PATIENT (USERNAME, BIRTH_DATE, EMPLOYMENT_STATUS, FIRST_NAME, GENDER, LAST_NAME, MARITAL_STATUS) VALUES
  ('john89', '1989-11-11', 'UNEMOLOYED', 'John', 'MALE', 'DOE', 'SINGLE'),
  ('jane02', '2002-10-10', 'STUDENT', 'Jane', 'FEMALE', 'DOE', 'SINGLE');



/* CONCRETE DIAGNOSES */

INSERT INTO DIAGNOSIS (ID, NAME, DISORDER_GROUP_ID) VALUES

    /* MOOD DISORDER DIAGNOSES */
    (1, 'Depressive disorder', 1),
    (2, 'Bipolar disorder', 1),

    /* ANXIETY DISORDER DIAGNOSES */
    (3, 'Post-traumatic stress disorder', 2),
    (4, 'Generalized anxiety disorder', 2),
    (5, 'Social anxiety disorder', 2),
    (6, 'Panic disorder', 2),

    /* EATING DISORDER DIAGNOSES */
    (7, 'Anorexia nervosa', 3),
    (8, 'Bulimia nervosa', 3),

    /* PSYCHOTIC DISORDER DIAGNOSES */
    (9, 'Schizophrenia', 4),

    /* ANXIETY DISORDER DIAGNOSES */
    (10, 'Borderline personality disorder', 5),
    (11, 'Obsessive-compulsive disorder', 5),
    (12, 'Antisocial personality disorder', 5),
    (13, 'Paranoid personality disorder', 5);


