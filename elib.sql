/*Script para o banco de dados, feito no pgadmin4*/

CREATE TABLE IF NOT EXISTS public.livros (
    id serial PRIMARY KEY,
    nome character varying(80) NOT NULL,
    sinopse text,
    genero character varying(80) NOT NULL,
    capa character varying,
    arquivo_livro character varying
);

CREATE TABLE IF NOT EXISTS public.locacao_livros (
    id serial PRIMARY KEY,
    id_usuario integer NOT NULL,
    id_livro integer NOT NULL,
    data_inicio date,
    data_fim date
);

CREATE TABLE IF NOT EXISTS public.usuarios (
    id serial PRIMARY KEY,
    nome character varying(80) NOT NULL,
    sobrenome character varying(80) NOT NULL,
    usuario character varying(50) NOT NULL,
    senha character varying NOT NULL,
    admin boolean NOT NULL
);

INSERT INTO public.livros (id, nome, sinopse, genero, capa, arquivo_livro)
VALUES
    (1, '50 Anos Luz, Camera e Acao', 'Sempre bem-humorado, com uma verve que revela nesse livro em dezenas de causos a servir de deflagradores dos temas que expõe, o autor, um dos mais criativos diretores de fotografia do Brasil, aborda o tema da iluminação e filmagem cinematográficas com requinte técnico e estético, e com muita elegância.', 'Didatico', 'Capas/Didatico/50 anos luz, camera e acao.jpeg', 'Livros/Didatico/50 anos luz, camera e acao.pdf'),
    (2, 'A Experiência do Cinema', 'Na antologia A experiência do cinema, Ismail Xavier reúne textos de teóricos, críticos, filósofos e cineastas das tradições francesa, anglófona, russa e alemã, produzidos entre 1916 e 1980. Assim, apresenta as principais teorias e uma abrangente reflexão sobre o cinema, revelando a diversidade de análises que têm marcado o pensamento sobre a experiência cinematográfica – desde as explicações básicas dos cineastas do princípio do século até as sínteses e novas propostas estéticas do pensamento contemporâneo.', 'Didatico', 'Capas/Didatico/a experiencia do cinema.jpeg', 'Livros/Didatico/a experiencia do cinema.pdf'),
    (3, 'A Linguagem Cinematografica', 'Um estudo clássico sobre a linguagem característica do cinema, indispensável para estudantes, amantes e praticantes da sétima arte.', 'Didatico', 'Capas/Didatico/a linguagem cinematografica.jpeg', 'Livros/Didatico/a linguagem cinematografica.pdf'),
    (4, 'As Principais Teorias do Cinema', 'Uma história das teorias do cinema e uma introdução à obra dos principais autores que se dedicaram ao assunto. "Andrew faz um apanhado das principais teorias que tentaram explicar a estética cinematográfica, desde o cinema mudo até os anos setenta."', 'Didatico', 'Capas/Didatico/as principais teorias do cinema.jpg', 'Livros/Didatico/as principais teorias do cinema.pdf'),
    (5, 'Duna', 'A vida do jovem Paul Atreides está prestes a mudar radicalmente. Após a visita de uma mulher misteriosa, ele é obrigado a deixar seu planeta natal para sobreviver ao ambiente árido e severo de Arrakis, o Planeta Deserto. Envolvido numa intrincada teia política e religiosa, Paul divide-se entre as obrigações de herdeiro e seu treinamento nas doutrinas secretas de uma antiga irmandade, que vê nele a esperança de realização de um plano urdido há séculos. Ecos de profecias ancestrais também o cercam entre os nativos de Arrakis. Seria ele o eleito que tornaria viáveis seus sonhos e planos ocultos?', 'Ficção Cientifica', 'Capas/Ficcao cientifica/duna.jpg', 'Livros/Ficcao cientifica/duna.pdf'),
    (6, 'Eu Sou a Lenda', 'O livro Eu sou a Lenda, do romancista norte-americano Richard Matheson, é uma das mais importantes obras do horror e da ficção científica, originalmente lançada em 1954 e deu origem a três adaptações para o cinema. O clássico, que influenciou a obra de grandes mestres do horror como Stephen King e George A. Romero, recebeu uma edição especial em capa dura e alguns extras: uma entrevista concedida por Matheson na qual ele fala sobre as influências e as adaptações do romance para o cinema e uma crítica do professor Mathias Classen, da Universidade de Aarhus, Dinamarca, analisando as questões bioculturais do romance. A obra de Matheson – um dos principais autores do século XX – modificou o modo de fazer filmes e livros de horror atualmente. O uso da ciência, como a medicina e a biologia, para explicar o surgimento dos vampiros, utilizada em Eu Sou a Lenda, oferece ao público um viés mais realista e possível, diferente de grandes nomes do gênero como H. P. Lovecraft, que tem suas raízes no sobrenatural. Sua influência é tão grande, que, mesmo com a obra citando somente vampiros, ela formou o imaginário do que seria um apocalipse zumbi. A história se passa em um futuro não muito distante, quando todo o mundo é assolado por uma impiedosa praga. Homens, mulheres e até crianças são transformados em monstros carnívoros, e é nesse cenário pós-apocalíptico, tomado por criaturas da noite sedentas de sangue, que Robert Neville se torna o último homem na Terra e passa os dias em busca de comida e suprimentos, lutando para manter-se vivo e são. Mas os infectados espreitam pelas sombras, prontos para acabar com o último bastião da humanidade.', 'Ficção Cientifica', 'Capas/Ficcao cientifica/eu sou a lenda.jpg', 'Livros/Ficcao cientifica/eu sou a lenda.pdf'),
    (7, 'Amor Sem Limites', '“Rush me conquistou em Tentação sem limites, mas, ah, minha nossa... ele me fez derreter por completo neste livro. Você não vai se decepcionar.” – The Autumn Review Blaire Wynn conheceu Rush Finlay num momento muito difícil da vida dela, logo depois de perder a mãe e a casa em que morava. Filho de um astro do rock, Rush vivia num mundo de luxo, sexo sem compromisso e total despreocupação com o futuro. Exatamente o oposto de tudo o que Blaire conhecia. Mesmo com tantas diferenças, a paixão entre os dois foi arrebatadora. Porém Rush guardava um segredo de sua família que levou ao fim do namoro – e a um período de tristeza absoluta para o casal. Mas eles já não sabiam viver um sem o outro e cederam de novo àquele sentimento irresistível. Agora Blaire está grávida, eles estão felizes e planejam se casar. Mas nem tudo está garantido. O pai de Rush chega trazendo más notícias e novamente os antigos problemas de família podem fazer com que os dois se afastem. Último volume da trilogia Sem Limites, que já vendeu mais de 5 milhões de exemplares no mundo todo, Amor sem limites é um livro sexy que vai fazer você acreditar que para cada problema há uma solução – e, quando se trata de relacionamento, a cama é sempre um bom local para resolver conflitos. **** Rush ainda não tinha voltado. Ele não havia respondido a nenhuma das minhas ligações ou mensagens. Eu passara mais de quatro horas na clínica e ele não me ligara nem uma vez. Meu filho estava bem, mas o médico tinha dito que eu precisava descansar, ingerir mais líquidos e não me estressar. Se eu não seguisse suas orientações, precisaria ficar de repouso na cama. Olhei para meu telefone para conferir se não havia perdido alguma ligação desde a última vez que o conferira, três minutos antes. Estava tentando não me preocupar com Rush. Tinha que diminuir o estresse. Meu filho precisava disso. Permanecer em Los Angeles lidando com os problemas de família não ia me ajudar. Eu precisava ir embora. Mas voltar para Rosemary não parecia uma boa ideia. Só me faria sentir saudade de Rush. Meus pensamentos foram interrompidos por uma batida na porta. Abri-a e encontrei um Dean de aparência cansada. – Rush ligou para Kiro e disse que Georgianna está vindo para cá. Não sei quanto tempo levará para chegar, só achei que talvez você quisesse saber que a rainha má está a caminho. Só escutei que Rush havia ligado. O resto não importava. Rush estava bem. Estava com o telefone. Só não queria me atender. Mais uma vez, deparei com a verdade brutal de que a irmã dele era mais importante. Balancei a cabeça e fechei a porta. Fechei os olhos bem forte. Eu ia mesmo deixar Rush. Isso me partia o coração.', 'Romance', 'Capas/Romance/amor sem limites.jpg', 'Livros/Romance/amor sem limites.pdf'),
    (8, 'Beleza Perdida', 'Beleza perdida é a história de uma cidadezinha onde cinco jovens vão para a guerra e apenas um retorna. É uma história sobre perdas — perda coletiva, perda individual, perda da beleza, perda de vidas, perda de identidade, mas também ganhos incalculáveis. É um conto sobre o amor inabalável de uma garota por um guerreiro ferido. Este é um livro profundo e emocionante sobre a amizade que supera a tristeza, sobre o heroísmo que desafia as definições comuns, além de uma releitura moderna de A Bela e a Fera, que nos faz descobrir que há tanto beleza quanto ferocidade em todos nós.', 'Romance', 'Capas/Romance/beleza perdida.jpg', 'Livros/Romance/beleza Perdida.pdf'),
    (9, 'Caminho', 'Aurora, era uma garota cheia de sonhos, que começaram a ser destruídos, aos poucos. Após a morte de seu pai, tudo que ela queria era uma vida digna e melhor para a mãe, mas tudo mudou. Quando sua mãe conhece um homem e se casa novamente, se transformando em outra mulher.', 'Romance', 'Capas/Romance/caminho.jpg', 'Livros/Romance/caminho.pdf'),
    (10, 'Escravos', 'Conheça o livro que deu origem à série de sucesso The Underground Railroad, do Amazon Prime Video e disponível no Prime Video, vencedora de quatro prêmios Emmy. Cada capítulo de The Underground Railroad abre uma época importante e terrível da história da escravidão americana, começando com a passagem de Cora pela Geórgia e passando por Carolina do Sul e Carolina do Norte, antes de ela finalmente chegar a Indiana, onde as coisas são um pouco melhores. A narrativa narra uma série de histórias separadas que também dão forma a uma narrativa maior. Através da fuga de Cora, acompanhamos a história dos estados americanos antes, durante e após a guerra civil. A cada nova parada, conhecemos os horrores da escravidão por meio dos olhos de diferentes personagens, todos unidos pelo sonho de encontrar um mundo novo e melhor. Livro originalmente publicado pela HarperCollins US, com os ISBNs 978-0-385-54236-4 (eBook) e 978-0-385-54235-7 (hardcover).', 'Romance', 'Capas/Romance/escravos.jpg', 'Livros/Romance/escravos.pdf');

INSERT INTO public.usuarios (id, nome, sobrenome, usuario, senha, admin)
VALUES
    (1, 'Admin', 'Admin', 'admin', 'admin', true),
    (2, 'Usuario', 'Padrao', 'usuario', 'usuario', false);

INSERT INTO public.locacao_livros (id_usuario, id_livro, data_inicio, data_fim)
VALUES
    (1, 1, '2023-10-01', '2023-10-15'),
    (1, 2, '2023-10-01', '2023-10-15'),
    (1, 3, '2023-10-01', '2023-10-15');


ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuario UNIQUE (usuario);

ALTER TABLE ONLY public.locacao_livros
    ADD CONSTRAINT "fk->pk livros_id" FOREIGN KEY (id_livro) REFERENCES public.livros(id) NOT VALID;

ALTER TABLE ONLY public.locacao_livros
    ADD CONSTRAINT "fk->pk usuarios_id" FOREIGN KEY (id_usuario) REFERENCES public.usuarios(id) NOT VALID;