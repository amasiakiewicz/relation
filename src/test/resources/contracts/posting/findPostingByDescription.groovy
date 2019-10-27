package contracts.posting

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return posting by description=olo"

    request {
        url "/postings/olo"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                date: "2018-04-05",
                account: "1232435",
                description: "olo"
        )
    }
}
