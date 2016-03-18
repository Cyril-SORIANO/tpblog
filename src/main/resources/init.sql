INSERT IGNORE INTO `Role` (`id`, `description`, `name`) VALUES
  (1, 'ROLE_ADMIN', 'Admin'),
  (2, 'ROLE_USER', 'Utilisateur'),
  (3, 'ROLE_AUTEUR', 'Auteur');

  INSERT IGNORE INTO `Personne` (`id`, `nom`, `password`, `role_id`) VALUES
  (1, 'Cyril', 'aaa', 1),
  (2, 'John Harper', 'jh123', 2),
  (3, 'Anonymous', '1234', 3);
  
  INSERT IGNORE INTO `Categorie` (`id`, `name`, `url`) VALUES
  (1,'Fêtes','www.myblog/fetes.fr'),
  (2,'Conférences','www.myblog/conferences.fr'),
  (3,'Offres d''emplois','www.myblog/offres.fr'),
  (4,'Petites annonces','www.myblog/annonces.fr');