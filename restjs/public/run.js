var curl;
(function () {

    curl.config({
        main: 'muyi',
        packages: {
            // Your application's packages
            muyi: { location: 'muyi' },
            // Third-party packages
            curl: { location: 'lib/curl/src/curl' },
            rest: { location: 'lib/rest', main: 'rest' },
            when: { location: 'lib/when', main: 'when' }
        }
    });

}());