$(document).ready(function() {

    $('#searchBox').on('input', () => {
        let query = $("#searchBox").val();
        let href = `/lookup/${query}`;
        $('form').prop('action', href.toString())
    });

    let wsURL = $('body').data('ws-url');
    let ws = new WebSocket(wsURL)

    ws.onopen = function (ev) {
        console.log('Connection opened', ev);
        let { pathname } = new URL(window.location);

        switch (true) {
            case pathname.includes('/thread'): {
                let query = $('h3').attr('data-search');
                let data = JSON.stringify({ type: 'thread', query });
                ws.send(data);
            }
                
            case pathname.includes('/profile'): {
                 let query = $('h3').attr('data-search');
                 let data = JSON.stringify({ type: 'userProfile', query });
                 ws.send(data);
                        }

            default: {
                let searchResults = $('section').map(function () {
                    return $(this).attr('data-search');
                }).toArray();
                // loop through current results and add subscriptions to websockets
                searchResults.forEach((query) => {
                    let data = JSON.stringify({ type: 'search', query });
                    ws.send(data);
                });
            }
        }
    }

    ws.onclose = function (ev) {
        console.log('Connection closed', ev);
    }

    ws.onerror = function (ev) {
        console.log('Connection errored', ev);
    }

    ws.onmessage = function (event) {
        let result = JSON.parse(event.data);
        result.data = JSON.parse(result.data);
        console.dir({ result });
        result && writeSection(result);
    };

    function getRandomNumber(max) {
        return Math.floor(Math.random() * max) + 1;
    }

    function getRandomData(data = []) {
        if (data.length >= 10) {
            let start = getRandomNumber(data.length - 10);
            return data.slice(start, start + 10);
        } else {
            return data;
        }
    }

    function writeSection({ query, data }) {
        let result = getRandomData(data);
        let section = $(`tbody[data-section="${query}"]`);

        section.empty();
        let innerHtml = "";
        result.forEach(function (post) {
            innerHtml += `
                <tr data-key="${post.title}">
                    <td>${post.title}</td>
                    <td>${post.selftext || "-"}</td>
                    <td><a href="/user/${post.author}">${post.author}</a></td>
                    <td><a href="/thread/${post.subreddit}">${post.subreddit}</a></td>
                </tr>
            `
        });

        section.append(innerHtml);
    }
});
