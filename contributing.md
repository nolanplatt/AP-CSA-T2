# Team Purple Contributing Guidelines

<hr>

Team Purple is committed to ensuring the Github community is able to contribute and add to our project this trimester. We are very appreciative in anyone wanting to contribute, but before creating a pull request or otherwise altering the repository, please ensure you take a careful look at these contributing guidelines.



## Reporting Bugs

<hr>

To report a bug, simply create an issue by clicking [here](https://github.com/nolanplatt/AP-CSA-T2/issues). Issues will be reviewed by our team. Please ensure you include steps on how to reproduce the error/bug and also include any relevant information on your machine (ex: Windows 10x64, InteliJ). Issues that do not include relevant information or are simply irrelevant will be closed.

## Making Changes

<hr>

If you find a big, error, or even a typo, feel free to fix it by pulling the repository, fixing it, and then creating a pull request. In your pull request, include information on the error, the cause of it, and how you fixed it. Relevant pull requests that pass tests will be merged into the main repository. For more information, see the section below.

### Pull Requests

<hr>

Once you've fixed the bug or just wanted to patch or add something to the project, create the pull request. Please ensure that you provide a tangible link to the issue that was relevant with the pull request, if there is one. If there isn't an issue, please create one and attach is so we stay organized. Once you do that, simply submit the pull request and wait for our team to review it. If all is well, we will approve it and merge it into the repository. If there are issues, we will leave feedback on why and you can make changes so that we're able to merge it.



## .Gitignore

<hr>

It is extremely important that you utilize .gitignore when publishing changes or attemtping to merge files into our repository. We heavily emphasize the usage of the plain text file .gitignore for many reasons. Any sensitive information that needs to be excluded from public view should be included in the .gitignore file. 

Examples of things that **need** to be in .gitignore and be excluded from the repository:

>
>
>1. dependency directories 
>2. configuration files for IDEs or other computing softwares
>3. runtime generated files
>4. files with sensitive information (.ENV files, etc)

Any contribution that includes the aforementioned information, and anything that extends off of it, will be rejected.

There are multiple methods to use the .gitignore file to its upmost ability. See below.

1. Simply type ".<filename>" in your terminal, excluding the "<>". This will make Github ignore any file called <filename>.
2. To ignore an entire directory, usually in cases that have modules or packages, simply do "<filedirectory>/". With the slash after the directory path, Github will ignore that entire directory (all files in it and the folder/directory in general).











 