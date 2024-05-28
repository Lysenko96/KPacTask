INSERT INTO k_pac(title, description)
VALUES
    ('title1', 'description1'),
    ('title2', 'description2'),
    ('title3', 'description3');

INSERT INTO k_pac_set(title)
VALUES
    ('set1'),
    ('set2');

INSERT INTO k_pac_k_pac_sets(k_pac_id, k_pac_set_id)
VALUES
    (1,1),
    (2,1),
    (3,2);