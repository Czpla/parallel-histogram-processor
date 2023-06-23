# Projeto de Extração de Histogramas de Imagens

Este projeto Java é responsável por ler imagens de um diretório, extrair o histograma de cada imagem e processá-los em paralelo usando a interface Runnable. No final, exibe o tempo total necessário para processar as imagens e grava os dados em um arquivo chamado `result.txt`.

## Referências

As imagens utilizadas neste projeto foram obtidas do repositório [CIFAR-10 Images](https://github.com/YoongiKim/CIFAR-10-images/tree/master). O CIFAR-10 é um conjunto de dados amplamente utilizado na área de visão computacional, contendo 60.000 imagens coloridas divididas em 10 classes distintas.

## Funcionalidades

- Leitura das imagens de um diretório específico.
- Extração do histograma de cada imagem.
- Processamento paralelo dos histogramas usando a interface Runnable.
- Cálculo do tempo total necessário para processar as imagens.
- Gravação dos dados em um arquivo de texto `result.txt`.

## Pré-requisitos

- JDK (Java Development Kit) instalado.
- IDE Java (VsCode, Eclipse, IntelliJ, etc.) ou linha de comando para compilar e executar o projeto.

## Instruções de Uso

1. Clone ou faça o download do repositório em seu ambiente de desenvolvimento.
2. Abra o projeto em sua IDE Java.
3. Compile e execute o arquivo `Main.java`.
4. Após a conclusão do processamento, será exibido o tempo total necessário para processar as imagens e o arquivo `result.txt` será gerado contendo os dados dos histogramas.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests para melhorias no código, correções de bugs ou novas funcionalidades.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
