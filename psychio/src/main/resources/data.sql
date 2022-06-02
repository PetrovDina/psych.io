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



-- STATEMENTS

INSERT INTO STATEMENT (OCCURENCE, CONTENT, DIAGNOSIS_ID) VALUES
    -- DEPRESSION STATEMENTS
    (3, 'I have little interest or pleasure in doing things', 1),
    (3, 'I feel down, depressed, or hopeless', 1),
    (3, 'I feel tired or have little energy', 1),
    (3, 'I have self harmed', 1),
    (3, 'I have had thoughts that I would be better off dead, or of hurting myself', 1),
    (3, 'These problems have made it difficult for me at work, home, school, or with other people', 1),
    (3, 'My sex drive has reduced', 1),
    (3, 'Getting up in the morning is hard', 1),
    (3, 'I feel guilty or tearful for no apparent reason', 1),
    (3, 'I find myself avoiding friends and family', 1),
    (2, 'I feel about myself - or that I are a failure or have let myself or my family down', 1),
    (2, 'I have had poor appetite or overate', 1),
    (2, 'I have trouble falling or staying asleep, or sleeping too much', 1),
    (2, 'I have no motivation ', 1),
    (1, 'I have had trouble concentrating on things, such as reading the newspaper or watching television', 1),

    --BIPOLAR STATEMENTS
    (3, 'At times I am MUCH more talkative or speak MUCH faster than usual.', 2),
    (3, 'There have been times when I was MUCH more active or did MANY more things than usual.', 2),
    (3, 'I get into moods where I feel VERY speeded up or irritable.', 2),
    (3, 'There have been times when I have felt both high (elated) and low (depressed) AT THE SAME TIME.', 2),
    (3, 'At times I have been MUCH more interested in sex than usual.', 2),
    (3, 'My self-confidence ranges from GREAT self-doubt to EQUALLY GREAT overconfidence.', 2),
    (3, 'There have been GREAT variations in the quantity or quality of my work.', 2),
    (3, 'FOR NO OBVIOUS REASON I sometimes have been VERY angry or hostile.', 2),
    (3, 'Sometimes I am mentally dull and at other times I think VERY creatively.', 2),
    (2, 'At some times I have GREAT optimism and at other times EQUALLY GREAT pessimism', 2),
    (2, 'Some of the time I show MUCH tearfulness and crying and at other times I laugh and joke EXCESSIVELY.', 2),
    (1, 'At times I am GREATLY interested in being with people and at other times I just want to be left alone with my thoughts.', 2),

    --PTSD STATEMENTS
    (3, 'I have experienced, witnessed or heard about a traumatic event', 3),
    (3, 'Since this event occurred, I have experienced recurrent involuntary memories or dreams that make me suffer', 3),
    (3, 'I become distressed by sights, sounds, smells or feelings that remind me of the traumatic event', 3),
    (3, 'I try not to see people, go to places or see objects that are associated with the traumatic event', 3),
    (3, 'These issues have caused significant difficulties in my relationships, work or school', 3),
    (2, 'I have trouble remembering some important aspects of the traumatic event', 3),
    (2, 'I feel fear, guilt or shame about the traumatic event', 3),
    (2, 'I am always on high alert', 3),
    (2, 'I have developed problems with sleep', 3),
    (1, 'I have become uninterested in activities I enjoyed before the traumatic event', 3),
    (1, 'I feel more disconnected from people', 3),
    (1, 'I am feeling angrier than before the traumatic event occurred', 3),

    --GAD STATEMENTS
    (3, 'I worry about lots of different things', 4),
    (3, 'I have trouble controlling my worries', 4),
    (3, 'Worry or anxiety make me feel fatigued or worn out', 4),
    (3, 'I worry about things working out in the future', 4),
    (3, 'I worry about things that have already happened in the past', 4),
    (2, 'My muscles get tense when I are worried or anxious', 4),
    (2, 'Worry or anxiety interfere with falling and/or staying asleep', 4),
    (2, 'I feel jumpy and/or tense', 4),

    --SOCIAL ANXIETY STATEMENTS
    (3, 'I feel anxious or panicky before social situations', 5),
    (3, 'I avoid social situations because of fear or anxiety', 5),
    (3, 'I avoid situations, or feel uncomfortable, where I do not know people well', 5),
    (3, 'It is easy to imagine that others are judging me as anxious, weak, crazy, stupid, boring or unlikeable when I am in a group setting', 5),
    (3, 'When in social situations, I worry that people will notice I am experiencing anxiety symptoms such as blushing, trembling, sweating, stumbling over your words, or staring', 5),
    (3, 'I experience significant worrying about being in certain social situations which is out of proportion to the threat posed by the social situation', 5),
    (2, 'I panic when you have to do something in front of others, whether speaking up in a meeting or presenting to a group', 5),
    (2, 'I fear that I will be negatively evaluated by others when in social situations', 5),

    --PANIC ANXIETY STATEMENTS
    (3, 'I have experienced abrupt surges of intense fear or discomfort seemingly out of the blue, that lasted several minutes', 6),
    (3, 'I have experienced some of the following symptoms during those minutes: Palpitations, pounding heart, or accelerated heart rate', 6),
    (3, 'Sweating', 6),
    (3, 'Trembling or shaking', 6),
    (3, 'Shortness of breath or a feeling that you are being smothered', 6),
    (3, 'Nausea or stomach ache', 6),
    (3, 'Worried that you are going to die', 6),
    (3, 'I have taken steps to avoid a repeat attack—for example, avoiding unfamiliar situations', 6),
    (3, 'I have a fear of a certain situation, animal, or object that causes me to experience the panic, sweating, trembling, and/or heart palpitations', 6),
    (2, 'I have a sense of being detached from myself or my surroundings, or observing myself from outside my body. Or, that things are not real.', 6),
    (2, 'Chills or heat sensations', 6),
    (1, 'People often tell me I look nervous', 6),

    --ANOREXIA STATEMENTS
    (3, 'I am terrified of being overweight', 7),
    (3, 'I avoid eating when I am hungry', 7),
    (3, 'I find myself preoccupied with food', 7),
    (3, 'I know the calorie content of everything I eat', 7),
    (3, 'I like my stomach to be empty', 7),
    (3, 'I am preoccupied with the thought of having fat on my body', 7),
    (3, 'I think about burning up calories when I exercise', 7),
    (3, 'I am preoccupied by my desire to be thinner', 7),
    (3, 'I feel that food controls my life', 7),
    (3, 'I feel extreme guilt after eating', 7),
    (2, 'I cut my food into small pieces before eating', 7),
    (2, 'Others have said they want me to eat more', 7),
    (2, 'Other people think I am too thin', 7),
    (2, 'I eat diet foods', 7),
    (2, 'I feel that others pressurise me to eat', 7),
    (2, 'I give a lot of time and thought to food', 7),
    (1, 'I take longer to eat meals than other people do', 7),
    (1, 'I avoid foods high in carbohydrates', 7),

    --BULIMIA STATEMENTS
    (3, 'When I lose control over my eating, I eat more rapidly than I usually do.', 8),
    (3, 'When I lose control over my eating, I eat more food than others would under similar circumstances.', 8),
    (3, 'When I cannot stop eating, I eat so much that I feel uncomfortably full afterwards.', 8),
    (3, 'I eat even though I am not hungry.', 8),
    (3, 'When I lose control over my eating, I eat alone because I feel embarrassed or ashamed of what or how much I am eating.', 8),
    (3, 'I lose control over my eating or feel like I cannot stop eating once I have started.', 8),
    (3, 'I feel disgusted with myself, depressed, or very guilty after I feel I have overeaten.', 8),
    (3, 'I make myself vomit after I feel that I jave eaten too much.', 8),
    (3, 'I take laxatives or diuretics after I feel that I have eaten too much', 8),
    (3, 'I exercise hard or strenuously in order to make up for times I lose control over my eating.', 8),
    (3, 'I fast, skip meals, or diet strictly after I feel I have eaten too much.', 8),
    (3, 'I feel dissatisfied with my body shape and/or weight.', 8),
    (2, 'My life is a vicious cycle between the moments I lose control over my eating and the time I diet to lose my weight', 8),
    (2, 'If I gained weight, it would affect how I feel about myself as a person.', 8),
    (2, 'If a favorite clothing item of mine was suddenly too small for me, it would affect how I feel about myself as a person.', 8),
    (2, 'I have a strong desire to lose weight.', 8),
    (1, 'I am distressed as a result of my eating habits. ', 8),

    -- SCHIZOPHRENIA PSYCHOTIC STATEMENTS
    (3, 'I hear or see things that others cannot', 9),
    (3, 'Sometimes I get the sense that others are controlling my thoughts and emotions', 9),
    (3, 'I have abilities and/or powers that other people cannot understand or appreciate', 9),
    (3, 'I find it difficult to organize or keep track of my thinking', 9),
    (3, 'Sometimes I feel that I am being tracked, followed, or watched at home or outside', 9),
    (3, 'People have a difficult time guessing my emotions by my facial expressions and actions', 9),
    (2, 'I struggle to trust that what I am thinking is real', 9),
    (2, 'Other people say that it is difficult for me to stay on subject or for them to understand me', 9),
    (1, 'I am struggling with maintaining social relationships, employment, and/or academic demands', 9),
    (1, 'I struggle to keep up with daily living tasks such as showering, changing clothes, paying bills, cleaning, cooking, etc.', 9),

    -- BORDERLINE PERSONALITY STATEMENTS
    (3, 'My relationships are very intense, unstable, and alternate between the extremes of over idealizing and undervaluing people who are important to me', 10),
    (3, 'My emotions change very quickly, and I experience intense episodes of sadness, irritability, and anxiety or panic attacks.', 10),
    (3, 'My level of anger is often inappropriate, intense, and difficult to control.', 10),
    (3, 'Now, or in the past, when upset, I have engaged in recurrent suicidal behaviors, gestures, threats, or self-injurious behavior such as cutting, burning, or hitting myself.', 10),
    (3, 'I have a significant and persistently unstable image or sense of myself, or of who I am or what I truly believe in.', 10),
    (3, 'I have very suspicious ideas, and am even paranoid (falsely believe that others are plotting to cause me harm); or I experience episodes under stress when I feel that I, other people, or the situation is somewhat unreal.', 10),
    (3, 'I engage in two or more self-damaging acts such as excessive spending, unsafe and inappropriate sexual conduct, substance abuse, reckless driving, and binge eating.', 10),
    (3, 'I engage in frantic efforts to avoid real or imagined abandonment by people who are close to me', 10),
    (3, 'I suffer from feelings of emptiness and boredom.', 10),
    (3, 'I often idealize others, especially when I first meet them, and feel comfortable in sharing the most intimate details with them. But I often feel that these same people do nott care enough and are not there enough for me.', 10),
    (3, 'I often experience a sudden shift in the way I look at myself and my life, and completely change my goals, values and career focus.', 10),
    (3, 'My views of others - especially those I care about - can shift dramatically and without any warning.', 10),
    
    -- OCD PERSONALITY STATEMENTS
    (3, 'I have experienced unwanted repetitive and persistent thoughts that cause me anxiety', 11),
    (3, 'I fear contamination (i.e. germs) from people or the environment.', 11),
    (3, 'I do excessive or ritualized washing, cleaning, or grooming', 11),
    (3, 'I experience the need to constantly check on something (i.e. repeatedly checking to be sure doors are locked, light switches and/or appliances are off) or arrange the order of things (a shelf in a bedroom or a kitchen cabinet, for example)', 11),
    (3, 'I experience intrusive thoughts that are aggressive (i.e. harm to yourself or others) or about taboo topics such as porn', 11),
    (3, 'I attempt to ignore/suppress these unwanted thoughts/images or engage in another activity (i.e. counting, hand washing, checking repeatedly to be sure doors are locked) to neutralize them.', 11),
    (3, 'I engage in rituals that provide temporary relief to your anxiety, such as counting, checking, or cleaning', 11),
    (3, 'I spend at least one hour a day thinking obsessive thoughts or performing ritualistic behavior in an attempt to avoid angst', 11),
    (3, 'I get thoughts of, for example, accidentally hitting a pedestrian with my car, or letting my call roll down the hill', 11),
    (2, 'I get intrusive images of death or other horrible events', 11),
    (2, 'I worry about terrible things such as fires, burglaries, floods..', 11),
    (2, 'I get thoughts of harm coming to a loved one because I was not careful enough', 11),
    (2, 'I have a hard time getting rid of things and/or hoard', 11),

 
    --ANTISOCIAL PERSONALITY DISORDER
    (3, 'I tend to lie to or trick others for my own gain or pleasure', 12),
    (3, 'I find yourself unable to empathize with others dealing with difficult situations', 12),
    (3, 'If I hurt someone elses feelings, I am told I lack remorse or guilt', 12),
    (3, 'I engage in unnecessary risk-taking or dangerous behavior with no regard for the safety of self or others', 12),
    (3, 'I consider myself superior to others', 12),
    (3, 'I use charm or wit to manipulate others for my own benefit', 12),
    (3, 'It would not be distressing if I succeeded because someone else failed', 12),
    (3, 'Morality is for other people and I care about mainly about what is right for me in the moment', 12),
    (2, 'People say I am selfish and always put myself first ', 12),
    (2, 'I tend to act impulsively', 12),
    (2, 'I consistently fail to fulfill work and/or financial obligations', 12),
    (2, 'I have engaged in criminal behavior', 12),
    (2, 'I tend to be aggressive', 12),

    --PARANOID PERSONALITY DISORDER
    (3, 'I am often suspicious of other people or question their motives', 13),
    (3, 'I believe people are trying to harm or trick me, even if there’s no evidence', 13),
    (3, 'I feel suspicious of people who have acted loyally towards you', 13),
    (3, 'I am reluctant to confide in or open up to others because I fear the information will be maliciously used against me in the future.', 13),
    (3, 'I perceive nonthreatening remarks as insults or as personal attacks', 13),
    (3, 'I perceive attacks on my character or reputation that aren not usually apparent to others, and am quick to react angrily or to counterattack.', 13),
    (2, 'I respond with hostility or anger when I feel insulted', 13),
    (2, 'I hold grudges', 13),
    (2, 'I tend to suspect that my romantic partner is unfaithful', 13);